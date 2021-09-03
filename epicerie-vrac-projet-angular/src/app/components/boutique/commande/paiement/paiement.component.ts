import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from 'src/app/models/commande';
import { Utilisateur } from 'src/app/models/utilisateur';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ClientService } from 'src/app/services/client.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css']
})
export class PaiementComponent implements OnInit {

  constructor(private _aus: AuthenticationService,
              private _cs: ClientService,
              private _r: Router) { }

  ngOnInit(): void {
  }

  onCommander(): void {
    this._cs.saveCommande(this._aus.utilisateur.id).subscribe(() => console.log("Commande réussi"));
  }

}
