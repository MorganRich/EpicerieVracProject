import { LigneAchat } from "./ligne-achat";

export class Achat {
    public id: number = 0;
    public prixTotal: number = 0;
    public articles: LigneAchat[] = [];
}
