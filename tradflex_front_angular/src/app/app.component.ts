import {Component, OnInit} from '@angular/core';
import { FILM} from "./filmList";
import {film} from "./film";

@Component({
  selector: 'app-root',
  template:`<h1>list film</h1>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  filmlist = FILM;
  ngOnInit():void {
    console.table(this.filmlist);
    this.selectFilm(this.selectFilm( [0]));
  }
  selectFilm(film : film){
    console.log(`Vous avez cliqué sur ${film.title}`);
  }
}
