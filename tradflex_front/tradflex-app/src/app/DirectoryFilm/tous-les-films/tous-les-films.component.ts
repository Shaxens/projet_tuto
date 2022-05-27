import { Component, OnInit } from '@angular/core';
import { Film } from '../../film';
import { FilmServiceService } from '../film-service.service';
@Component({
  selector: 'app-tous-les-films',
  templateUrl: './tous-les-films.component.html',
  styleUrls: ['./tous-les-films.component.css']
})
//cette class permet de recuperer les films
export class TousLesFilmsComponent implements OnInit {
filmList : Film[] | undefined;
  constructor(private filmService : FilmServiceService) {
  }

  ngOnInit(): void {
    this.filmService.getFilmList()
      .subscribe(filmList => this.filmList= filmList);//je m'abonne au flux de donnée de l'observable pour recevoir une liste de film
    //quand je reçois la liste de film je la pousse dans filmList
  }

}
