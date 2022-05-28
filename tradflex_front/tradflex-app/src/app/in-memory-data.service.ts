import { Injectable } from '@angular/core';//Creation d'une interface pour simuler une bdd
import { InMemoryDbService} from "angular-in-memory-web-api";
import { PROJET } from "./projetList";

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{
//fake api
 createDb(){//FProjet = liste de projet dans mon dossier projetlist.ts
   const projets = PROJET;
   return { projets };
 }
}
