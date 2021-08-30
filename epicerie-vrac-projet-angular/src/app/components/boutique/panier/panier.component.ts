import { Component, OnInit } from '@angular/core';
import { LigneAchat } from 'src/app/models/ligne-achat';
import { Panier } from 'src/app/models/panier';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-panier',
  templateUrl: './panier.component.html',
  styleUrls: ['./panier.component.css']
})
export class PanierComponent implements OnInit {

  public panier: Panier = new Panier();

  constructor(private _gps: GestionPanierService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
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
