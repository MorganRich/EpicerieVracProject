import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Categorie } from '../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  private _categoriesUrl = "http://localhost:8080/categories";

  constructor(private _hc: HttpClient) { }

  findAll(): Observable<Categorie[]> {
    return this._hc.get<Categorie[]>(this._categoriesUrl);
  }

  findById(id: number): Observable<Categorie> {
    return this._hc.get<Categorie>(this._categoriesUrl + "/" + id);
  }

  save(c: Categorie): Observable<any> {
    return this._hc.post(this._categoriesUrl, c);
  }

  update(a: Categorie): Observable<any> {
    return this._hc.put(this._categoriesUrl + "/" + a.id, a);
  }

  delete(a: Categorie): Observable<any> {
    return this.deleteById(a.id);
  }

  deleteById(id: number): Observable<any> {
    return this._hc.delete(this._categoriesUrl + "/" + id);
  }
  
}
