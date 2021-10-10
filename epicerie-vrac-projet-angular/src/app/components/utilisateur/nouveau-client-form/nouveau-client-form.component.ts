import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Adresse } from 'src/app/models/adresse';
import { Client } from 'src/app/models/client';
import { Panier } from 'src/app/models/panier';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ClientService } from 'src/app/services/client.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-nouveau-client-form',
  templateUrl: './nouveau-client-form.component.html',
  styleUrls: ['./nouveau-client-form.component.css']
})
export class NouveauClientFormComponent implements OnInit, OnDestroy {
  
  public client: Client = new Client();
  public creationCompte: boolean = false;
  public adresse1: Adresse = new Adresse();
  public adresse2: Adresse = new Adresse();
  public adresseDifferente: boolean = false;
  
  public panier: Panier = new Panier();

  constructor(private _cs: ClientService,
              private _aus: AuthenticationService,
              private _gps: GestionPanierService,
              private _r: Router) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
  }

  ngOnDestroy(): void {
    this._gps.panierSubject.unsubscribe();
  }

  onEnregistrer() {
    if (this.creationCompte) {
      this.client.personne.adresses.push(this.adresse1);
      if (this.adresseDifferente) {
        this.adresse2.id = 1;
        this.client.personne.adresses.push(this.adresse2);
      }
      this.client.role = "ROLE_CLIENT"
      this.client.panier = this.panier;
      this._cs.save(this.client).subscribe(() => {
        this._aus.signin(this.client.email, this.client.password).subscribe(() => {
          this._r.navigateByUrl("commande");
        });
      });
    }
  }

}
