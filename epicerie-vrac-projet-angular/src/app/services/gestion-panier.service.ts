import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Article } from '../models/article';
import { LigneAchat } from '../models/ligne-achat';
import { Panier } from '../models/panier';
import { AuthenticationService } from './authentication.service';
import { ClientService } from './client.service';

@Injectable({
  providedIn: 'root'
})
export class GestionPanierService {

  public panier: Panier = new Panier();
  public quantiteLignePanier: Subject<number> = new Subject<number>();
  public quantiteMax: Subject<boolean> = new Subject<boolean>();
  public panierSubject: BehaviorSubject<Panier> = new BehaviorSubject<Panier>(this.panier);

  constructor(private _as: AuthenticationService,
              private _cs: ClientService) { }

  ajouterArticle(a: Article, quantite: number): void {
    let index = this.panier.articles.findIndex(la => la.id.article.id == a.id);
    if (index == -1) {
      let ajout: LigneAchat = new LigneAchat();
      ajout.id.article = a;
      ajout.quantite = quantite;
      this.panier.articles.push(ajout);
      this.panierSubject.next(this.panier);
    }
    else {
      if (this.panier.articles[index].quantite + quantite <= a.quantiteEnStock) {
        this.panier.articles[index].quantite = this.panier.articles[index].quantite + quantite;
        this.quantiteLignePanier.next(this.panier.articles[index].quantite);
        this.quantiteMax.next(false);
      }
      else {
        this.panier.articles[index].quantite = a.quantiteEnStock;
        this.quantiteLignePanier.next(this.panier.articles[index].quantite);
        this.quantiteMax.next(true);
      }
    }
    this.calculerPrixTotal();
    if (this._as.connected)
      this._cs.savePanier(this._as.utilisateur.id, this.panier).subscribe(() => console.log("save panier ok !!"));
  }

  supprimerArticle(index: number): void {
    this.panier.articles.splice(index, 1);
    this.calculerPrixTotal();
    this.panierSubject.next(this.panier);
    if (this._as.connected)
      this._cs.savePanier(this._as.utilisateur.id, this.panier).subscribe(() => console.log("save panier ok !!"));
  }

  augmenterQuantite(index: number): void {
    if (this.panier.articles[index].quantite < this.panier.articles[index].id.article.quantiteEnStock) {
      this.panier.articles[index].quantite++;
      this.calculerPrixTotal();
      this.panierSubject.next(this.panier);
    }
  }

  diminuerQuantite(index: number): void {
    if (this.panier.articles[index].quantite > 1) {
      this.panier.articles[index].quantite--;
      this.calculerPrixTotal();
      this.panierSubject.next(this.panier);
    }
  }

  calculerPrixTotal(): void {
    this.panier.prixTotal = this.panier.articles.map(la => la.id.article.prixUnitaire * la.quantite)
                                                .reduce((acc, value) => acc + value, 0);
  }

}
