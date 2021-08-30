import { Article } from "./article";
import { Commande } from "./commande";
import { Panier } from "./panier";
import { Personne } from "./personne";

export class Client extends Personne {
    public password: string = "";
    public panier: Panier = new Panier();
    public commandes: Commande[] = [];
    public favoris: Article[] = [];
}
