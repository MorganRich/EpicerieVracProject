import { Injectable } from '@angular/core';
import { Panier } from '../models/panier';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public connected: boolean = false;
  public username: string = "";
  public password: string = "";

  constructor() { }
}
