import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Client } from '../models/client';
import { Utilisateur } from '../models/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private _url = "http://localhost:8080";

  public connected: boolean = false;
  public utilisateur: Utilisateur = new Utilisateur();

  public connectedSubject: Subject<boolean> = new Subject<boolean>();
  public utilisateurSubject: BehaviorSubject<Utilisateur> = new BehaviorSubject<Utilisateur>(this.utilisateur);

  constructor(private _hc: HttpClient) { }

  signin(email: string, password: string): Observable<Utilisateur> {
    return this._hc.post<Utilisateur>(this._url + "/authentification", {}, {
      params: {
        "email": email,
        "password": password
      }
    }).pipe(tap(u => {
          this.utilisateur = u;
          this.utilisateur.password = password;
          this.connected = true;
          this.connectedSubject.next(this.connected);
          this.utilisateurSubject.next(this.utilisateur);
        }));
  }

  signout() {
    this.utilisateur = new Utilisateur();
    this.connected = false;
    this.connectedSubject.next(this.connected);
    this.utilisateurSubject.next(this.utilisateur);
  }

}
