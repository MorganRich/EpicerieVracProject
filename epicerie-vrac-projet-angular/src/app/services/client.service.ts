import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../models/client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private _url = "http://localhost:8080";
  private _clientsUrl = "http://localhost:8080/clients";

  constructor(private _hc: HttpClient) { }

  findAll(): Observable<Client[]> {
    return this._hc.get<Client[]>(this._clientsUrl);
  }

  findById(id: number): Observable<Client> {
    return this._hc.get<Client>(this._clientsUrl + "/" + id);
  }

  save(c: Client): Observable<any> {
    return this._hc.post(this._clientsUrl, c);
  }

  update(c: Client): Observable<any> {
    return this._hc.put(this._clientsUrl + "/" + c.id, c);
  }

  delete(c: Client): Observable<any> {
    return this.deleteById(c.id);
  }

  deleteById(id: number): Observable<any> {
    return this._hc.delete(this._clientsUrl + "/" + id);
  }

}
