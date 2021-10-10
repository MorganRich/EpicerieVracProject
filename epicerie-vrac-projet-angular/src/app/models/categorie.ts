export class Categorie {
    public id: number = 0;
    public nom: string = "";
    // public surCategorie: Categorie = new Categorie();
    public sousCategorie: Categorie[] = [];
    // public articles: Article[] = [];
}
