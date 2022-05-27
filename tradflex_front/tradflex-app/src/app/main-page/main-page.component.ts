import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Film} from "../film";
import {FILM} from "../filmList";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  filmList: Film[] = FILM;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  creerProjet() {
    this.router.navigate(['creerProjet']);
  }
  
  modifierProjet(film : Film) {
    this.router.navigate(['modifier', film.id]);
    }
}
