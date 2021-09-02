import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleAddComponent } from './components/boutique/article-add/article-add.component';
import { ArticleDetailsComponent } from './components/boutique/article-details/article-details.component';
import { BoutiqueComponent } from './components/boutique/boutique/boutique.component';
import { CommandeComponent } from './components/boutique/commande/commande.component';
import { PanierComponent } from './components/boutique/panier/panier.component';
import { ConnexionPageComponent } from './components/utilisateur/connexion-page/connexion-page.component';
import { AdminGuard } from './guards/admin.guard';
import { AuthenticatedGuard } from './guards/authenticated.guard';

const routes: Routes = [
  {path: "boutique", component: BoutiqueComponent},
  {path: "article/add", component: ArticleAddComponent, canActivate: [AdminGuard]},
  {path: "article/:id", component: ArticleDetailsComponent},
  {path: "panier", component: PanierComponent},
  {path: "commande", component: CommandeComponent},
  {path: "mon-compte", component: ConnexionPageComponent},
  {path: "mon-compte/:id", component: ConnexionPageComponent, canActivate: [AuthenticatedGuard]},
  {path: "**", redirectTo: "/boutique"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
