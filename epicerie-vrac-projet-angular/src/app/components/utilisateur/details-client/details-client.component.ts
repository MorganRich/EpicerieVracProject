import { Component, Input, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client';
import { Utilisateur } from 'src/app/models/utilisateur';

@Component({
  selector: 'app-details-client',
  templateUrl: './details-client.component.html',
  styleUrls: ['./details-client.component.css']
})
export class DetailsClientComponent implements OnInit {

  @Input()
  public utilisateur: Utilisateur = new Utilisateur();

  public client: Client = new Client();

  constructor() { }

  ngOnInit(): void {
    this.client = this.utilisateur as Client;
  }

}
