import { Component, OnInit } from '@angular/core';
import { Adresse } from 'src/app/models/adresse';
import { Client } from 'src/app/models/client';
import { Panier } from 'src/app/models/panier';
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

  constructor(private _gps: GestionPanierService,
              private _cs: ClientService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
  }

  onCommander(): void {
    this.client.personne.adresses.push(this.adresse1);
    if (this.adresseDifferente)
      this.client.personne.adresses.push(this.adresse2);
    if (this.creationCompte)
      this.client.role = "ROLE_CLIENT"
    this._cs.save(this.client).subscribe(() => console.log("Enregistrement d'un nouveau client ok"));
  }

}
