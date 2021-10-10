import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router, UrlSegment } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ClientService } from 'src/app/services/client.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-connexion-form',
  templateUrl: './connexion-form.component.html',
  styleUrls: ['./connexion-form.component.css']
})
export class ConnexionFormComponent implements OnInit {

  public connexionForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required]),
    seSouvenir: new FormControl(false)
  });

  public route: UrlSegment[] = [];
  
  constructor(private _as: AuthenticationService,
              private _cs: ClientService,
              private _gps: GestionPanierService,
              private _r: Router,
              private _ar: ActivatedRoute) { }

  ngOnInit(): void {
    this._ar.url.subscribe(ar => {
      this.route = ar;
    });
  }

  get email() {
    return this.connexionForm.get('email');
  }

  get password() {
    return this.connexionForm.get('password');
  }

  onConnexion(): void {
    this._as.signin(this.connexionForm.controls.email.value, this.connexionForm.controls.password.value).subscribe(
      () => {
        if (this.route[0].path == "commande") {
          this._cs.savePanier(this._as.utilisateur.id, this._gps.panier).subscribe(() => console.log("save panier ok !!"));
          this._r.navigateByUrl("/commande");
        }
        else {
          if (this._gps.panier.articles.length == 0) {
            this._cs.findById(this._as.utilisateur.id).subscribe((c) => this._gps.initialiserPanier(c.panier));
          }
          else if (this._gps.panier.articles.length > 0) {
            this._cs.savePanier(this._as.utilisateur.id, this._gps.panier).subscribe(() => console.log("save panier ok !!"));
          }
          this._r.navigateByUrl("/boutique");
        }
      });
  }

}
