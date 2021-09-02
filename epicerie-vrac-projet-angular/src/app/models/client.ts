import { Article } from "./article";
import { Commande } from "./commande";
import { Panier } from "./panier";
import { Personne } from "./personne";
import { Utilisateur } from "./utilisateur";

export class Client extends Utilisateur {
    public panier: Panier = new Panier();
    public commandes: Commande[] = [];
    public favoris: Article[] = [];
    public personne: Personne = new Personne();
}
