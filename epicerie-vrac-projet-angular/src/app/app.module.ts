import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './app-material.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthenticationInterceptor } from './interceptors/authentication.interceptor';
import { AuthenticationService } from './services/authentication.service';
import { MenuComponent } from './components/headers/menu/menu.component';
import { BoutiqueComponent } from './components/boutique/boutique/boutique.component';
import { ArticleCardComponent } from './components/boutique/article-card/article-card.component';
import { NavigationHeaderComponent } from './components/headers/navigation-header/navigation-header.component';
import { ArticleLineComponent } from './components/boutique/article-line/article-line.component';
import { ArticleDetailsComponent } from './components/boutique/article-details/article-details.component';
import { PanierComponent } from './components/boutique/panier/panier.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BoutiqueComponent,
    ArticleCardComponent,
    NavigationHeaderComponent,
    ArticleLineComponent,
    ArticleDetailsComponent,
    PanierComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
      deps: [AuthenticationService]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
