import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { Article } from 'src/app/models/article';
import { ArticleService } from 'src/app/services/article.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-article-details',
  templateUrl: './article-details.component.html',
  styleUrls: ['./article-details.component.css']
})
export class ArticleDetailsComponent implements OnInit {

  public article: Article = new Article();
  public quantite: number = 1;
  public quantitePanier: number = 0;
  public quantiteMax: boolean = false;

  constructor(private _as: ArticleService,
              private _ar: ActivatedRoute,
              private _gps: GestionPanierService,
              @Inject(MAT_DIALOG_DATA) private _data: {article : Article}) { }

  ngOnInit(): void {
    // this.article.id = this._ar.snapshot.params.id;
    // this._as.findById(this.article.id).subscribe(a => this.article = a);
    console.log(this._data);
    this.article = this._data.article;
    this._gps.quantiteLignePanier.subscribe(qte => this.quantitePanier = qte);
    this._gps.quantiteMax.subscribe(max => this.quantiteMax = max);
  }

  onDownQuantite() {
    if (this.quantite > 1)
      this.quantite--;
  }

  onUpQuantite() {
    if (this.quantite < this.article.quantiteEnStock)
      this.quantite++;
  }

  onAddPanier() {
    this._gps.ajouterArticle(this.article, this.quantite);
  }

}
