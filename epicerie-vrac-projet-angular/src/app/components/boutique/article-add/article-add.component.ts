import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Article } from 'src/app/models/article';
import { Categorie } from 'src/app/models/categorie';
import { ArticleService } from 'src/app/services/article.service';
import { UniteMesure } from "src/app/models/unite-mesure";
import { CategorieService } from 'src/app/services/categorie.service';

@Component({
  selector: 'app-article-add',
  templateUrl: './article-add.component.html',
  styleUrls: ['./article-add.component.css']
})
export class ArticleAddComponent implements OnInit {

  public article: Article = new Article();
  public categories: Categorie[] = [];
  public image: string = "";
  public uniteMesure: UniteMesure[] = [];

  constructor(private _as: ArticleService,
              private _cs: CategorieService,
              private _r: Router) { }

  ngOnInit(): void {
    this._cs.findAll().subscribe(cat => this.categories = cat);
    this.uniteMesure[0] = UniteMesure.KILO;
    this.uniteMesure[1] = UniteMesure.LITRE;
    this.uniteMesure[2] = UniteMesure.UNITE;
  }

  onFileSelect(event: any): void {
    if (event.target.files.length > 0)
      this.image = event.target.files[0];
    else
      this.image = "";
  }

  onSubmit(): void {
    const formData = new FormData();
    formData.append('article', new Blob([JSON.stringify(this.article)], {type: 'application/json'}));
    formData.append('file', this.image);
    this._as.save(formData).subscribe(() => {
      console.log("Enregistrement OK");
      this._r.navigateByUrl("boutique");
    });
  }

}
