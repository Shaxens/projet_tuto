import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Projet} from "../projet";
import {PROJET} from "../projetList";

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  projetList: Projet[] = PROJET;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  creerProjet() {
    this.router.navigate(['creerProjet']);
  }

  editerProjet(projet: Projet) {
    this.router.navigate(['editer', projet.id]);
  }
  
  modifierProjet(projet : Projet) {
    this.router.navigate(['parametre', projet.id]);
    }
}
