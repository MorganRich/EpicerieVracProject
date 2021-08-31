import { Component, Input, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-article-line',
  templateUrl: './article-line.component.html',
  styleUrls: ['./article-line.component.css']
})
export class ArticleLineComponent implements OnInit {

  @Input()
  public article: Article = new Article();

  constructor(private _gps: GestionPanierService) { }

  ngOnInit(): void {
  }

  onAjouterPanier(): void {
    this._gps.ajouterArticle(this.article, 1);
  }

}
