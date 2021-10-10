import { Component, OnDestroy, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article';
import { Panier } from 'src/app/models/panier';
import { ArticleService } from 'src/app/services/article.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-commande-details',
  templateUrl: './commande-details.component.html',
  styleUrls: ['./commande-details.component.css']
})
export class CommandeDetailsComponent implements OnInit, OnDestroy {

  public panier: Panier = new Panier();
  
  constructor(private _gps: GestionPanierService,
              private _as: ArticleService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
  }

  ngOnDestroy(): void {
    this._gps.panierSubject.unsubscribe();
  }

  getUrlImage(article: Article): string {
    return this._as.image(article);
  }

}
