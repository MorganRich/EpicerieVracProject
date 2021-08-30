import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { Article } from '../models/article';
import { LigneAchat } from '../models/ligne-achat';
import { Panier } from '../models/panier';

@Injectable({
  providedIn: 'root'
})
export class GestionPanierService {

  public panier: Panier = new Panier();

  public quantiteLignePanier: Subject<number> = new Subject<number>();
  public quantiteMax: Subject<boolean> = new Subject<boolean>();

  public panierSubject: BehaviorSubject<Panier> = new BehaviorSubject<Panier>(this.panier);

  constructor() { }

  ajouterArticle(a: Article, quantite: number): void {
    let index = this.panier.articles.findIndex(la => la.article === a);
    if (index == -1) {
      let ajout: LigneAchat = new LigneAchat();
      ajout.article = a;
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
  }

  supprimerArticle(index: number): void {
    this.panier.articles.splice(index, 1);
    this.panierSubject.next(this.panier);
  }

  augmenterQuantite(index: number): void {
    if (this.panier.articles[index].quantite < this.panier.articles[index].article.quantiteEnStock) {
      this.panier.articles[index].quantite++;
      this.panierSubject.next(this.panier);
    }
  }

  diminuerQuantite(index: number): void {
    if (this.panier.articles[index].quantite > 1) {
      this.panier.articles[index].quantite--;
      this.panierSubject.next(this.panier);
    }
  }

  calculerPrixTotal() {
    this.panier.prixTotal = this.panier.articles.map(la => la.article.prixUnitaire * la.quantite)
                                                .reduce((acc, value) => acc + value, 0);
  }

}
