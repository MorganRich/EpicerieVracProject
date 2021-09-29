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
              private _r: Router) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
  }

  onCommander(): void {
    this._r.navigateByUrl("/commande");
  }

  onViderPanier(): void {
    this._gps.viderPanier();
    this._r.navigateByUrl("/boutique");
  }

}
