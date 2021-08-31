import { Achat } from "./achat";
import { Client } from "./client";

export class Panier extends Achat {

    constructor(client: Client) {
        super();
        this.client = client;
    }

    public client: Client;
}
