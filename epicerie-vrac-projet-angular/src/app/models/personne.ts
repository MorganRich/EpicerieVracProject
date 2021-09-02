import { Adresse } from "./adresse";

export class Personne {
    public id: number = 0;
    public nom: string = "";
    public prenom: string = "";
    public numeroTelephone: string = "";
    public adresses: Adresse[] = [];
}
