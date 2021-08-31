import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
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

  public email = new FormControl('', [Validators.required, Validators.email]);
  public password = new FormControl('', [Validators.required]);
  public seSouvenir: boolean = false;

  public creationCompte: boolean = false;
  public adresseDifferente: boolean = false;

  public client: Client = new Client();
  public adresse1: Adresse = new Adresse();
  public adresse2: Adresse = new Adresse();
  public panier: Panier = new Panier(this.client);

  constructor(private _gps: GestionPanierService,
              private _cs: ClientService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(p => this.panier = p);
    console.log(this.client);
  }

  getErrorMessage() {
    if (this.email.hasError('required') || this.password.hasError('required')) {
      return 'Champ obligatoire !';
    }
    return this.email.hasError('email') ? 'Email non valide !' : '';
  }

  onConnexion(): void {
    console.log(this.email.value + this.password.value);
  }

  onCommander(): void {
    this.client.adresses.push(this.adresse1);
    if (this.adresseDifferente)
      this.client.adresses.push(this.adresse2);
    if (this.creationCompte)
      this.client.role = "ROLE_CLIENT"
    console.log(this.client);
    this._cs.save(this.client).subscribe(() => console.log("save"));
  }

}
