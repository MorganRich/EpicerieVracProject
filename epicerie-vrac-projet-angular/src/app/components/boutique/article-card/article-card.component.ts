import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';
import { ArticleDetailsDialogComponent } from '../article-details-dialog/article-details-dialog.component';
import { ArticleDetailsComponent } from '../article-details/article-details.component';

@Component({
  selector: 'app-article-card',
  templateUrl: './article-card.component.html',
  styleUrls: ['./article-card.component.css']
})
export class ArticleCardComponent implements OnInit {

  @Input()
  public article: Article = new Article();

  @Input()
  public urlImage: string = "";

  @Input()
  public utilisateur: Client = new Client();

  @Output()
  deleteEvent = new EventEmitter<number>();

  constructor(private _gps: GestionPanierService,
              private _as: AuthenticationService,
              public dialog: MatDialog) { }

  ngOnInit(): void {

  }

  onAjouterPanier(): void {
    this._gps.ajouterArticle(this.article, 1);
  }

  openDialog(): void {
    const dialogRef = this.dialog.open(ArticleDetailsDialogComponent, {
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
