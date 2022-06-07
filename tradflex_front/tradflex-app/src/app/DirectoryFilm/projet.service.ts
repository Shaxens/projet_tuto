import { Injectable } from '@angular/core';
import {Projet} from "../projet";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class ProjetService {
  constructor(private http: HttpClient) {
  }
//methode http
  getProjetList(): Observable<Projet[]> {//on va recevoir la liste des Projets ou film qui arriveront dans le temps
    return this.http.get<Projet[]>('api/projets').pipe(//url + ce qu'on envoie et pipe pour definir ce que je veux faire en plus du traitement de la requete
      tap((response) => this.log(response)),//si je reçois une reponse alors je console log
      catchError((error) => this.handleError(error, []))
    );
  }

  getProjetById(projetId: number): Observable<Projet | undefined> {//peut renvoyer undefined
    return this.http.get<Projet>(`http://localhost:8080/project/${projetId}`, {
      headers:  {
        'Access-Control-Allow-Origin': '*',
        'Content-Type': 'application/json'
      }
    }).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, undefined))//Si aucun film ou projet return undefined
    );
  }

  searchProjetList(term: string): Observable<Projet[]> {
    if(term.length <= 1) {
      return of([]);
    }

    return this.http.get<Projet[]>(`api/projets/?name=${term}`).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, []))
    );
  }

  updateProjet(projet: Projet|undefined): Observable<null> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.put('api/projets',projet, httpOptions).pipe(//methode put pour enregistrer les modif d'un objet
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, null))
    );
  }

  addProjet(projet: Projet|undefined): Observable<Projet> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Projet>('api/projets', projet, httpOptions).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, null))
    );
  }

  deleteProjetById(projetId: number): Observable<null> {
    return this.http.delete(`api/projets/${projetId}`).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, null))
    );
  }

  private log(response: any) {
    console.table(response);
  }

  private handleError(error: Error, errorValue: any) {
    console.error(error);
    return of(errorValue);
  }

}
