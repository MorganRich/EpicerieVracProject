import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { Panier } from 'src/app/models/panier';
import { ArticleService } from 'src/app/services/article.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  public panier: Panier = new Client().panier;

  constructor(private _gps: GestionPanierService,
              private _as: ArticleService,
              private _r: Router) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
  }

  getUrlImage(article: Article): string {
    return this._as.image(article);
  }

  onSupprimer(index: number): void {
    this._gps.supprimerArticle(index);
  }

  onAugmenter(index: number): void {
    this._gps.augmenterQuantite(index);
  }

  onDiminuer(index: number): void {
    this._gps.diminuerQuantite(index);
  }

  onCommander(): void {
    this._r.navigateByUrl("/commande");
  }

}
