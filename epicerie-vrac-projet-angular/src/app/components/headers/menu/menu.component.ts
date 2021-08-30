import { Component, OnInit } from '@angular/core';
import { GestionPanierService } from 'src/app/services/gestion-panier.service';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  badgeValue: number = 0;

  constructor(private _gps: GestionPanierService) { }

  ngOnInit(): void {
    this._gps.panierSubject.subscribe(lp => this.badgeValue = lp.articles.length);
  }

}
