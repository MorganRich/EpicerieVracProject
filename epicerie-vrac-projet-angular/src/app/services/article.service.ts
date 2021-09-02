import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Article } from '../models/article';
import { Categorie } from '../models/categorie';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  private _url = "http://localhost:8080";
  private _articlesUrl = "http://localhost:8080/articles";

  constructor(private _hc: HttpClient) { }

  findAll(): Observable<Article[]> {
    return this._hc.get<Article[]>(this._articlesUrl);
  }

  findAllCategorie(): Observable<Categorie[]> {
    return this._hc.get<Categorie[]>(this._articlesUrl + "/categories");
  }

  findById(id: number): Observable<Article> {
    return this._hc.get<Article>(this._articlesUrl + "/" + id);
  }

  save(a: FormData): Observable<any> {
    return this._hc.post(this._articlesUrl, a);
  }

  update(a: Article): Observable<any> {
    return this._hc.put(this._articlesUrl + "/" + a.id, a);
  }

  delete(a: Article): Observable<any> {
    return this.deleteById(a.id);
  }

  deleteById(id: number): Observable<any> {
    return this._hc.delete(this._articlesUrl + "/" + id);
  }

  image(a: Article): string {
    if (a.image)
      return this._url + "/images/" + a.image;
    else
      return this._url + "/assets/images/produit.jpg";
  }

}
