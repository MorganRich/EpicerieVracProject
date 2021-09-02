import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Article } from 'src/app/models/article';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';
import { ArticleDetailsComponent } from '../article-details/article-details.component';

@Component({
  selector: 'app-article-line',
  templateUrl: './article-line.component.html',
  styleUrls: ['./article-line.component.css']
})
export class ArticleLineComponent implements OnInit {

  @Input()
  public article: Article = new Article();

  @Output()
  deleteEvent = new EventEmitter<number>();
  
  constructor(private _gps: GestionPanierService,
              public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  onAjouterPanier(): void {
    this._gps.ajouterArticle(this.article, 1);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(ArticleDetailsComponent, {
      data: {article: this.article}
    });

    // dialogRef.afterClosed().subscribe(result => {
    //   console.log(`Dialog result: ${result}`);
    // });
  }

  onUpdate(): void {

  }

  onDelete(): void {
    this.deleteEvent.emit(this.article.id);
  }

}
