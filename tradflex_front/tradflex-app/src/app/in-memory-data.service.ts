import { Injectable } from '@angular/core';//Creation d'une interface pour simuler une bdd
import { InMemoryDbService} from "angular-in-memory-web-api";
import { FILM} from "./filmList";

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{
//fake api
 createDb(){//FILM = liste de film dans mon dossier filmlist.ts
   const films = FILM;
   return { films };
 }
}
