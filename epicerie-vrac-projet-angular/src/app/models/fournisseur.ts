import { Article } from "./article";
import { Personne } from "./personne";

export class Fournisseur extends Personne {
    public nomEntreprise: string = "";
    public producteur: boolean = true;
    public description: string = "";
    public articles: Article[] = [];
}
