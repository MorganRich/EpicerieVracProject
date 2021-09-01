import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/authentication.service';

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
  })

  constructor(private _as:AuthenticationService,
              private _r: Router) { }

  ngOnInit(): void {
  }

  get email() {
    return this.connexionForm.get('email');
  }

  get password() {
    return this.connexionForm.get('password');
  }

  onConnexion(): void {
    console.log(this.connexionForm.controls.email.value + " " + this.connexionForm.controls.password.value);
    this._as.signin(this.connexionForm.controls.email.value, this.connexionForm.controls.password.value).subscribe(
      () => this._r.navigateByUrl("/boutique"));
  }

}
