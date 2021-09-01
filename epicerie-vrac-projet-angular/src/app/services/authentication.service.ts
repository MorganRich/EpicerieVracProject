import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Admin } from '../models/admin';
import { Client } from '../models/client';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private _url = "http://localhost:8080";

  public connected: boolean = false;
  public utilisateur: Client | Admin | undefined = undefined;

  public connectedClientSubject: Subject<boolean> = new Subject<boolean>();
  public utilisateurSubject: BehaviorSubject<Client | Admin | undefined> = new BehaviorSubject<Client | Admin | undefined>(this.utilisateur);

  constructor(private _hc: HttpClient) { }

  signin(email: string, password: string): Observable<Client | Admin> {
    return this._hc.post<Client | Admin>(this._url + "/authentification", {}, {
      params: {
        "email": email,
        "password": password
      }
    }).pipe(tap(r => {
          this.utilisateur = r;
          this.utilisateur.password = password;
          this.connected = true;
          this.connectedClientSubject.next(this.connected);
          this.utilisateurSubject.next(this.utilisateur);
        }));
  }

  signout() {
    this.utilisateur = undefined;
    this.connected = false;
    this.connectedClientSubject.next(this.connected);
    this.utilisateurSubject.next(this.utilisateur);
  }

}
