import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppMaterialModule } from './app-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
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
import { FooterComponent } from './components/footer/footer.component';
import { ConnexionFormComponent } from './components/utilisateur/connexion-form/connexion-form.component';
import { ConnexionPageComponent } from './components/utilisateur/connexion-page/connexion-page.component';
import { ArticleAddComponent } from './components/boutique/article-add/article-add.component';
import { ArticleDetailsDialogComponent } from './components/boutique/article-details-dialog/article-details-dialog.component';
import { NouveauClientFormComponent } from './components/utilisateur/nouveau-client-form/nouveau-client-form.component';
import { PaiementComponent } from './components/boutique/commande/paiement/paiement.component';
import { CommandePageComponent } from './components/boutique/commande/commande-page/commande-page.component';
import { DetailsClientComponent } from './components/utilisateur/details-client/details-client.component';
import { CommandeDetailsComponent } from './components/boutique/commande/commande-details/commande-details.component';
import { CompteComponent } from './components/utilisateur/compte/compte.component';
import { PanierDetailsComponent } from './components/boutique/panier-details/panier-details.component';
import { AccueilComponent } from './components/accueil/accueil.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    BoutiqueComponent,
    ArticleCardComponent,
    NavigationHeaderComponent,
    ArticleLineComponent,
    ArticleDetailsComponent,
    PanierComponent,
    FooterComponent,
    ConnexionFormComponent,
    ConnexionPageComponent,
    ArticleAddComponent,
    ArticleDetailsDialogComponent,
    NouveauClientFormComponent,
    PaiementComponent,
    CommandePageComponent,
    DetailsClientComponent,
    CommandeDetailsComponent,
    CompteComponent,
    PanierDetailsComponent,
    AccueilComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AppMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
      deps: [AuthenticationService]
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
