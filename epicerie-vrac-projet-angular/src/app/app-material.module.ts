import { NgModule } from '@angular/core';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatListModule} from '@angular/material/list';
import {MatMenuModule} from '@angular/material/menu';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import {MatDividerModule} from '@angular/material/divider';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatButtonToggleModule} from '@angular/material/button-toggle';
import {MatSelectModule} from '@angular/material/select';
import {MatBadgeModule} from '@angular/material/badge';
import {MatTableModule} from '@angular/material/table';


@NgModule({
  imports: [
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    MatMenuModule,
    MatCardModule,
    MatButtonModule,
    MatDividerModule,
    MatPaginatorModule,
    MatButtonToggleModule,
    MatSelectModule,
    MatBadgeModule,
    MatTableModule
  ],
  exports: [
    MatToolbarModule,
    MatListModule,
    MatIconModule,
    MatMenuModule,
    MatCardModule,
    MatButtonModule,
    MatDividerModule,
    MatPaginatorModule,
    MatButtonToggleModule,
    MatSelectModule,
    MatBadgeModule,
    MatTableModule
  ]
})
export class AppMaterialModule { }
