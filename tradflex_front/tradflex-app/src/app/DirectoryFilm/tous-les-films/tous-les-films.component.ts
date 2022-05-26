import { Component, OnInit } from '@angular/core';
import { Film } from '../../film';
import { FilmServiceService } from '../film-service.service';
@Component({
  selector: 'app-tous-les-films',
  templateUrl: './tous-les-films.component.html',
  styleUrls: ['./tous-les-films.component.css']
})
export class TousLesFilmsComponent implements OnInit {
filmList : Film[] | undefined;
  constructor(private filmService : FilmServiceService) {
  }

  ngOnInit(): void {
    this.filmList = this.filmService.getFilmList();
  }

}
