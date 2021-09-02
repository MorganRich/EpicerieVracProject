import { Achat } from "./achat";
import { Facture } from "./facture";

export class Commande extends Achat {
    public numeroCommande: number = 0;
    public dateCommande: Date = new Date();
    // public client: Client = new Client();
    public facture: Facture = new Facture();
}
