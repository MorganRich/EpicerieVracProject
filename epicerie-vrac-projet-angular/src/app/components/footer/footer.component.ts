import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/models/client';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  public connected: boolean = false;
  
  constructor(private _as: AuthenticationService) { }

  ngOnInit(): void {
    this._as.connectedSubject.subscribe(cs => this.connected = cs);
  }

}
