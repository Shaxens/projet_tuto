import { Component, OnInit } from '@angular/core';
import { Film } from '../../film';
import { FILM } from '../../filmList';
@Component({
  selector: 'app-formulaire-film',
  templateUrl: 'formulaire-film.component.html',
  styleUrls: ['formulaire-film.component.css']
})
export class FormulaireFilmComponent implements OnInit {
film = new Film(3,"jambon","yolo");
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(){
  console.log('Submit form');

  }
}
