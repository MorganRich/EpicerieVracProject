import { Adresse } from "./adresse";
import { Utilisateur } from "./utilisateur";

export abstract class Personne extends Utilisateur {
    public nom: string = "";
    public prenom: string = "";
    public numeroTelephone: string = "";
    public adresses: Adresse[] = [];
}
