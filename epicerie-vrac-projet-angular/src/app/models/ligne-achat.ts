import { Achat } from "./achat";
import { Article } from "./article"

export class LigneAchat {
    public article: Article = new Article();
    public achat: Achat | undefined;
    public quantite: number = 0;
}
