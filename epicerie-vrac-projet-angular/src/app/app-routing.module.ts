import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AccueilComponent } from './components/accueil/accueil.component';
import { ArticleAddComponent } from './components/boutique/article-add/article-add.component';
import { ArticleDetailsComponent } from './components/boutique/article-details/article-details.component';
import { BoutiqueComponent } from './components/boutique/boutique/boutique.component';
import { CommandePageComponent } from './components/boutique/commande/commande-page/commande-page.component';
import { PaiementComponent } from './components/boutique/commande/paiement/paiement.component';
import { PanierComponent } from './components/boutique/panier/panier.component';
import { CompteComponent } from './components/utilisateur/compte/compte.component';
import { ConnexionPageComponent } from './components/utilisateur/connexion-page/connexion-page.component';
import { AdminGuard } from './guards/admin.guard';
import { AuthenticatedGuard } from './guards/authenticated.guard';

const routes: Routes = [
  {path: "accueil", component: AccueilComponent},
  {path: "boutique/:categorieId", component: BoutiqueComponent},
  {path: "article/add", component: ArticleAddComponent, canActivate: [AdminGuard]},
  {path: "article/:id", component: ArticleDetailsComponent},
  {path: "panier", component: PanierComponent},
  {path: "commande", component: CommandePageComponent},
  {path: "paiement", component: PaiementComponent},
  {path: "connexion", component: ConnexionPageComponent},
  {path: "mon-compte", component: CompteComponent, canActivate: [AuthenticatedGuard]},
  {path: "**", redirectTo: "/accueil"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
