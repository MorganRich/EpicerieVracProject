import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adresse } from 'src/app/models/adresse';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { Panier } from 'src/app/models/panier';
import { Utilisateur } from 'src/app/models/utilisateur';
import { ArticleService } from 'src/app/services/article.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ClientService } from 'src/app/services/client.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.css']
})
export class CommandeComponent implements OnInit {

  public creationCompte: boolean = false;
  public adresseDifferente: boolean = false;
  public client: Client = new Client();
  public adresse1: Adresse = new Adresse();
  public adresse2: Adresse = new Adresse();

  public panier: Panier = new Panier();

  public connected: boolean = false;
  public utilisateur: Utilisateur = new Utilisateur();

  constructor(private _gps: GestionPanierService,
              private _aus: AuthenticationService,
              private _as: ArticleService,
              private _cs: ClientService,
              private _r: Router) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
    this._aus.utilisateurSubject.subscribe(u => this.utilisateur = u);
    this._aus.connectedSubject.subscribe(c => this.connected = c);
  }

  getUrlImage(article: Article): string {
    return this._as.image(article);
  }

  onCommander(): void {
    if (!this.connected && this.creationCompte) {
      this.client.personne.adresses.push(this.adresse1);
      if (this.adresseDifferente)
        this.client.personne.adresses.push(this.adresse2);
      this.client.role = "ROLE_CLIENT"
      this.client.panier = this.panier;
      this._cs.save(this.client).subscribe(() => {
        console.log("ok");
        this._aus.signin(this.client.email, this.client.password).subscribe(() => {
          console.log("ok2");
          this._r.navigateByUrl("/paiement");
        });
      });
    }
  }

}
