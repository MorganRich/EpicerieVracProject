import { Component, OnDestroy, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client';
import { AuthenticationService } from 'src/app/services/authentication.service';
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

  constructor(private _gps: GestionPanierService,
              private _as: AuthenticationService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(lp => this.badgeValue = lp.articles.length);
    this._as.connectedSubject.subscribe(cs => this.connected = cs);
    this._as.utilisateurSubject.subscribe(us => this.utilisateur = us);
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
