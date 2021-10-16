import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PagingAndSortingConfig } from 'src/app/interfaces/paging-and-sorting-config';
import { PagingAndSortingViewValue } from 'src/app/interfaces/paging-and-sorting-view-value';
import { Article } from 'src/app/models/article';
import { Categorie } from 'src/app/models/categorie';
import { Client } from 'src/app/models/client';
import { ArticleService } from 'src/app/services/article.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-boutique',
  templateUrl: './boutique.component.html',
  styleUrls: ['./boutique.component.css']
})
export class BoutiqueComponent implements OnInit, OnDestroy {

  public nbProduits: PagingAndSortingViewValue[] = [
    {value: 5, viewValue: 'Montrer 5 produits'},
    {value: 10, viewValue: 'Montrer 10 produits'},
    {value: 15, viewValue: 'Montrer 15 produits'}
  ];

  public triProduits: PagingAndSortingViewValue[] = [
    {value: "nom", viewValue: 'Trier par Nom'},
    {value: "prixUnitaire", viewValue: 'Trier par Prix'}
  ];

  public pagingAndSorting: PagingAndSortingConfig = {
    pageNo: 0, pageSize: 10,
    sortBy: "id", sortOrder: "descending",
    categorieId: 0
  };

  public articles: Article[] = [];
  public display: string | null = "";

  public utilisateur: Client = new Client();

  constructor(private _as: ArticleService,
              private _ar: ActivatedRoute,
              private _aus: AuthenticationService) { }

  ngOnInit(): void {
    // this._as.findAll().subscribe(articles => this.articles = articles);
    this.display = localStorage.getItem("display") != null ? localStorage.getItem("display") : "list";
    this._aus.utilisateurSubject.subscribe(us => this.utilisateur = us);
    this.pagingAndSorting.categorieId = parseInt(this._ar.snapshot.params.categorieId);
    this.getDataWithPagingAndSorting();
  }

  ngOnDestroy(): void {
    // this._aus.utilisateurSubject.unsubscribe();
  }

  getDataWithPagingAndSorting(): void {
    console.log(this.pagingAndSorting);
    this._as.findAllWithPagingAndSorting(this.pagingAndSorting).subscribe(a => this.articles = a);
  }

  getUrlImage(a: Article): string {
    return this._as.image(a);
  }

  onDisplayChange(d: string): void {
    this.display = d;
    localStorage.setItem("display", d);
  }

  onOrderChange(ordre: string): void {
    this.pagingAndSorting.sortOrder = ordre;
    this.getDataWithPagingAndSorting();
  }

  onSelectionChange(): void {
    this.pagingAndSorting.pageNo = 0;
    this.getDataWithPagingAndSorting();
  }

  onPreviousPage(): void {
    this.pagingAndSorting.pageNo = this.pagingAndSorting.pageNo - 1;
    this.getDataWithPagingAndSorting();
  }

  onNextPage(): void {
    this.pagingAndSorting.pageNo = this.pagingAndSorting.pageNo + 1;
    console.log(this.articles.length);
    this.getDataWithPagingAndSorting();
  }

  deleteById(id: number): void {
    this._as.deleteById(id).subscribe(() => {
      this._as.findAll().subscribe(articles => this.articles = articles);
      console.log("suppression OK");
    })
  }

}
