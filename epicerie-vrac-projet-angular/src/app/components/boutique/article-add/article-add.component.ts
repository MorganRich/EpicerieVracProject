import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Article } from 'src/app/models/article';
import { Categorie } from 'src/app/models/categorie';
import { ArticleService } from 'src/app/services/article.service';

@Component({
  selector: 'app-article-add',
  templateUrl: './article-add.component.html',
  styleUrls: ['./article-add.component.css']
})
export class ArticleAddComponent implements OnInit {

  public article: Article = new Article();
  public categories: Categorie[] = [];
  public image: string = "";

  constructor(private _as: ArticleService) { }

  ngOnInit(): void {
    this._as.findAllCategorie().subscribe(res => this.categories = res);
  }

  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.image = file;
    }
    else {
      this.image = "";
    }
  }

  onSubmit(): void {
    const formData = new FormData();
    formData.append('article', new Blob([JSON.stringify(this.article)], {type: 'application/json'}));
    formData.append('file',  this.image);
    this._as.save(formData).subscribe(() => "enregistrement OK");
  }

}
