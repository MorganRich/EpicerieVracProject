import { Adresse } from "./adresse";

export abstract class Personne {
    public id: number = 0;
    public nom: string = "";
    public prenom: string = "";
    public email: string = "";
    public numeroTelephone: string = "";
    public adresses: Adresse[] = [];
}
