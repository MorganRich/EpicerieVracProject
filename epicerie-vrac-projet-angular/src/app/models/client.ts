import { jsonIgnore } from "json-ignore";
import { Article } from "./article";
import { Commande } from "./commande";
import { Panier } from "./panier";
import { Personne } from "./personne";

export class Client extends Personne {
    public password: string = "";

    @jsonIgnore()
    public panier: Panier = new Panier(this);
    
    public commandes: Commande[] = [];
    public favoris: Article[] = [];
}
