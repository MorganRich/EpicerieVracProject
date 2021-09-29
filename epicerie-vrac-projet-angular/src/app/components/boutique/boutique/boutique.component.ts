import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { Utilisateur } from 'src/app/models/utilisateur';
import { ArticleService } from 'src/app/services/article.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

interface NombreProduit {
  value: number;
  viewValue: string;
}

interface TriProduit {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-boutique',
  templateUrl: './boutique.component.html',
  styleUrls: ['./boutique.component.css']
})
export class BoutiqueComponent implements OnInit {

  nbProduits: NombreProduit[] = [
    {value: 50, viewValue: 'Montrer 50 produits'},
    {value: 100, viewValue: 'Montrer 100 produits'},
    {value: 150, viewValue: 'Montrer 150 produits'}
  ];
  selectedNombreProduit = this.nbProduits[0].value;

  triProduits: TriProduit[] = [
    {value: "Nom", viewValue: 'Trier par Nom'},
    {value: "Prix", viewValue: 'Trier par Prix'}
  ];
  selectedTriProduit = this.triProduits[0].value;

  public articles: Article[] = [];
  public display: string | null = "";
  public tri: string | null = "";

  public utilisateur: Client = new Client();

  constructor(private _as: ArticleService,
              private _aus: AuthenticationService,
              private _gsp: GestionPanierService) { }

  ngOnInit(): void {
    this.getData();
    this.display = localStorage.getItem("display") != null ? localStorage.getItem("display") : "list";
    this.tri = localStorage.getItem("tri") != null ? localStorage.getItem("tri"): "up";
    this._aus.utilisateurSubject.subscribe(us => this.utilisateur = us);
  }

  getData(): void {
    this._as.findAll().subscribe(articles => this.articles = articles);
  }

  getUrlImage(a: Article): string {
    return this._as.image(a);
  }

  onDisplayChange(d: string): void {
    this.display = d;
    localStorage.setItem("display", d);
  }

  onTriChange(d: string): void {
    this.tri = d;
    localStorage.setItem("tri", d);
  }

  deleteById(id: number): void {
    this._as.deleteById(id).subscribe(() => {
      this.getData();
      console.log("suppression OK");
    })
  }

}
