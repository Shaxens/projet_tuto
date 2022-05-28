import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Projet} from "../projet";
import {PROJET} from "../projetList";
import { ProjetService } from '../DirectoryFilm/projet.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  projetList: Projet[] = PROJET;

  constructor(private router: Router,
  private projetService : ProjetService) { }

  ngOnInit(): void {
  }

  creerProjet() {
    this.router.navigate(['creerProjet/add']);
  }

  editerProjet(projet: Projet) {
    this.router.navigate(['editer', projet.id]);
  }

  modifierProjet(projet : Projet) {
    this.router.navigate(['parametre', projet.id]);
    }
  SupprimerProjet(projet :Projet){
    this.projetService.deleteProjetById(projet.id).subscribe( );
  }

}
