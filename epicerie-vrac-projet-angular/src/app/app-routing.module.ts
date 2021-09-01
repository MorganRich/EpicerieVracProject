import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleDetailsComponent } from './components/boutique/article-details/article-details.component';
import { BoutiqueComponent } from './components/boutique/boutique/boutique.component';
import { CommandeComponent } from './components/boutique/commande/commande.component';
import { PanierComponent } from './components/boutique/panier/panier.component';
import { ConnexionPageComponent } from './components/utilisateur/connexion-page/connexion-page.component';

const routes: Routes = [
  {path: "boutique", component: BoutiqueComponent},
  {path: "article/:id", component: ArticleDetailsComponent},
  {path: "panier", component: PanierComponent},
  {path: "commande", component: CommandeComponent},
  {path: "mon-compte", component: ConnexionPageComponent},
  {path: "**", redirectTo: "/boutique"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
