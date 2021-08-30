import { Personne } from "./personne";

export class Adresse {
    public id: number = 0;
    public numero: number = 0;
    public typeDeVoie: string = "";
    public complement: string = "";
    public codePostal: string = "";
    public ville: string = "";
    public personne: Personne | undefined;
}
