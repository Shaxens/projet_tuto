import { Injectable } from '@angular/core';
import {Film} from "../film";
import {FILM} from "../filmList";
@Injectable({
  providedIn: 'root'
})
export class FilmServiceService {

 getFilmList(): Film[]{
   return FILM//return une list de film
 }
 getFilmById(filmId:number): Film|undefined {//peut renvoyer undefined
   return FILM.find(film => film.id == filmId);//depuis mon tab de film je vais chercher le film avec l'identifiant en parametre
 }
}
