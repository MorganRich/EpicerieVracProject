import { Component, Input, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { Panier } from 'src/app/models/panier';
import { ArticleService } from 'src/app/services/article.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-panier-details',
  templateUrl: './panier-details.component.html',
  styleUrls: ['./panier-details.component.css']
})
export class PanierDetailsComponent implements OnInit {

  @Input()
  public panier: Panier = new Client().panier;
  
  constructor(private _as: ArticleService,
              private _gps: GestionPanierService) { }

  ngOnInit(): void {
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
  
}
