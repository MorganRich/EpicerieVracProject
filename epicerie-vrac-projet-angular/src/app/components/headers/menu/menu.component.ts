import { Component, OnDestroy, OnInit } from '@angular/core';
import { Categorie } from 'src/app/models/categorie';
import { Client } from 'src/app/models/client';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { CategorieService } from 'src/app/services/categorie.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit, OnDestroy {

  public badgeValue: number = 0;
  public connected: boolean = false;
  public utilisateur: Client = new Client();
  public categories: Categorie[] = [];

  constructor(private _gps: GestionPanierService,
              private _cs: CategorieService,
              private _as: AuthenticationService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(lp => this.badgeValue = lp.articles.length);
    this._as.connectedSubject.subscribe(cs => this.connected = cs);
    this._as.utilisateurSubject.subscribe(us => this.utilisateur = us);
    this._cs.findAll().subscribe(cat => {
      this.categories = cat;
      console.log(this.categories);
    });
  }

  ngOnDestroy(): void {
    this._gps.panierSubject.unsubscribe();
    this._as.connectedSubject.unsubscribe();
    this._as.utilisateurSubject.unsubscribe();
  }

  signout(): void {
    this._as.signout();
  }

}
