import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Film } from '../../film';
import { FilmServiceService } from '../film-service.service';

@Component({
  selector: 'app-edit-projet',
  templateUrl: './edit-projet.component.html',
  styleUrls: ['./edit-projet.component.css']
})
export class EditProjetComponent implements OnInit {
  film : Film|undefined;
  constructor(private route: ActivatedRoute,
              private filmService : FilmServiceService)
  { }

  ngOnInit(): void {
    const filmId: string|null = this.route.snapshot.paramMap.get('id');
    if(filmId){
    this.filmService.getFilmById(+filmId)
    .subscribe(film => this.film = film);
  } else {
  this.film = undefined;
}
}

}
