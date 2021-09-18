import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article';
import { Client } from 'src/app/models/client';
import { Utilisateur } from 'src/app/models/utilisateur';
import { ArticleService } from 'src/app/services/article.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { ClientService } from 'src/app/services/client.service';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {

  public utilisateur: Utilisateur = new Utilisateur();
  public client: Client = new Client();

  public panelOpenState: boolean = false;

  constructor(private _aus: AuthenticationService,
              private _as: ArticleService,
              private _cs: ClientService) { }

  ngOnInit(): void {
    this._aus.utilisateurSubject.subscribe(u => {
      this.utilisateur = u;
      if (this.utilisateur.role = "ROLE_CLIENT")
        this._cs.findById(this.utilisateur.id).subscribe(c => this.client = c);
    });
  }

  getUrlImage(article: Article): string {
    return this._as.image(article);
  }

}
