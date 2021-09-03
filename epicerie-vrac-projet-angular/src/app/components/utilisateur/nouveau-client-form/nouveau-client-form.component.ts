import { Component, OnInit } from '@angular/core';
import { Adresse } from 'src/app/models/adresse';
import { Client } from 'src/app/models/client';

@Component({
  selector: 'app-nouveau-client-form',
  templateUrl: './nouveau-client-form.component.html',
  styleUrls: ['./nouveau-client-form.component.css']
})
export class NouveauClientFormComponent implements OnInit {
  
  constructor() { }

  ngOnInit(): void {
  }

}
