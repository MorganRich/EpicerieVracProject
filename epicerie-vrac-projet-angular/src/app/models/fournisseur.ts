import { Article } from "./article";
import { Personne } from "./personne";

export class Fournisseur {
    public id: number = 0;
    public nomEntreprise: string = "";
    public email: string = "";
    public producteur: boolean = true;
    public description: string = "";
    public personne: Personne = new Personne();
    public articles: Article[] = [];
}
