import { Component, Inject, OnInit, OnDestroy } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { ArticleService } from 'src/app/services/article.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-article-details-dialog',
  templateUrl: './article-details-dialog.component.html',
  styleUrls: ['./article-details-dialog.component.css']
})
export class ArticleDetailsDialogComponent implements OnInit, OnDestroy {

  public article: Article = new Article();
  public quantite: number = 1;
  public quantitePanier: number = 0;
  public quantiteMax: boolean = false;

  public utilisateur: Client = new Client();
  
  constructor(private _gps: GestionPanierService,
              private _as: ArticleService,
              private _aus: AuthenticationService,
              @Inject(MAT_DIALOG_DATA) private _data: {article : Article}) { }

  ngOnInit(): void {
    this.article = this._data.article;
    this._gps.quantiteLignePanier.subscribe(qte => this.quantitePanier = qte);
    this._gps.quantiteMax.subscribe(max => this.quantiteMax = max);
    this._aus.utilisateurSubject.subscribe(us => this.utilisateur = us);
  }

  ngOnDestroy(): void {
    this._aus.utilisateurSubject.unsubscribe();
  }

  getUrlImage(): string {
    return this._as.image(this.article);
  }

  onDownQuantite(): void {
    if (this.quantite > 1)
      this.quantite--;
  }

  onUpQuantite(): void {
    if (this.quantite < this.article.quantiteEnStock)
      this.quantite++;
  }

  onAddPanier(): void {
    this._gps.ajouterArticle(this.article, this.quantite);
  }

  onUpdate(): void {
    // TODO
  }

  onDelete(): void {
    // TODO
  }

}
