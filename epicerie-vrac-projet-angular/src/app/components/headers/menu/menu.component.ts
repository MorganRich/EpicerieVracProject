import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client';
import { Utilisateur } from 'src/app/models/utilisateur';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  public badgeValue: number = 0;
  public connected: boolean = false;
  public utilisateur: Utilisateur = new Utilisateur();

  constructor(private _gps: GestionPanierService,
              private _as: AuthenticationService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(lp => this.badgeValue = lp.articles.length);
    this._as.connectedSubject.subscribe(cs => this.connected = cs);
    this._as.utilisateurSubject.subscribe(us => this.utilisateur = us);
  }

  signout(): void {
    this._as.signout();
  }

}
