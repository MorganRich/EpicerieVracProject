import { Categorie } from "./categorie";
import { UniteMesure } from "./unite-mesure";

export class Article {
    public id: number = 0;
    public reference: string = "";
    public nom: string = "";
    public image: string = "";
    public description: string = "";
    public bio: boolean = true;
    public lieuDeProduction: string = "";
    public prixUnitaire: number = 0;
    public uniteMesure: UniteMesure = UniteMesure.KILO;
    public pourcentagePromo: number = 0;
    public quantiteEnStock: number = 0;
    public nombreDeConsultation: number = 0;
    public categories: Categorie[] = [];
    // public fournisseurs: Fournisseur[] = [];
    // public achats: LigneAchat[] = [];
}
