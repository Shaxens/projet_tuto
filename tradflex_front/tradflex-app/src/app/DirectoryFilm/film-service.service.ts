import { Injectable } from '@angular/core';
import {Film} from "../film";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {catchError, Observable, of, tap} from "rxjs";
@Injectable({
  providedIn: 'root'
})
export class FilmServiceService {
  constructor(private http: HttpClient) {
  }
//methode http
  getFilmList(): Observable<Film[]> {//on va recevoir la liste des Projets ou film qui arriveront dans le temps
    return this.http.get<Film[]>('api/films').pipe(//url + ce qu'on envoie et pipe pour definir ce que je veux faire en plus du traitement de la requete
      tap((response) => this.log(response)),//si je reçois une reponse alors je console log
      catchError((error) => this.handleError(error, []))
    );
  }

  getFilmById(filmId: number): Observable<Film | undefined> {//peut renvoyer undefined
    return this.http.get<Film>(`api/films/${filmId}`).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, undefined))//Si aucun film ou projet return undefined
    );
  }
  searchFilmList(term: string): Observable<Film[]> {
    if(term.length <= 1) {
      return of([]);
    }

    return this.http.get<Film[]>(`api/films/?name=${term}`).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, []))
    );
  }

  updateFilm(film: Film): Observable<null> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.put('api/films',film, httpOptions).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, null))
    );
  }

  addFilm(film: Film): Observable<Film> {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Film>('api/films', film, httpOptions).pipe(
      tap((response) => this.log(response)),
      catchError((error) => this.handleError(error, null))
    );
  }

  deleteFilmById(filmId: number): Observable<null> {
    return this.http.delete(`api/films/${filmId}`).pipe(
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
