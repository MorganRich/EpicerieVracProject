import { BreakpointObserver } from '@angular/cdk/layout';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Commande } from 'src/app/models/commande';
import { Utilisateur } from 'src/app/models/utilisateur';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ClientService } from 'src/app/services/client.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-commande-page',
  templateUrl: './commande-page.component.html',
  styleUrls: ['./commande-page.component.css']
})
export class CommandePageComponent implements OnInit {

  // stepperOrientation: Observable<StepperOrientation>;

  public utilisateur: Utilisateur = new Utilisateur();
  public commande: Commande = new Commande();

  constructor(public breakpointObserver: BreakpointObserver,
              private _aus: AuthenticationService,
              private _cs: ClientService,
              private _gps: GestionPanierService,
              private _r: Router) 
              {
    // this.stepperOrientation = breakpointObserver.observe('(min-width: 800px)')
    //   .pipe(map(({matches}) => matches ? 'horizontal' : 'vertical'));
  }

  ngOnInit(): void {
    this._aus.utilisateurSubject.subscribe(u => this.utilisateur = u);
  }

  onModifierCompte(): void {
    this._r.navigateByUrl("mon-compte");
  }

  onModifierCommande(): void {
    this._r.navigateByUrl("panier");
  }

  onPayer(): void {
    this.commande.articles = this._gps.panier.articles;
    this.commande.prixTotal = this._gps.panier.prixTotal;
    this._cs.saveCommande(this._aus.utilisateur.id, this.commande).subscribe(() => {
        this._gps.viderPanier();
        this._r.navigateByUrl("mon-compte");
    });
  }

}
