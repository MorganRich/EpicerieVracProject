import { Achat } from "./achat";
import { Article } from "./article";
import { LigneAchatId } from "./ligne-achat-id";

export class LigneAchat {
    public id: LigneAchatId = new LigneAchatId();
    public quantite: number = 0;
}
