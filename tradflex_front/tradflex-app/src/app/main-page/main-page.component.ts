import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Projet, ProjetId} from "../projet";
import {PROJET} from "../projetList";
import { ProjetService } from '../DirectoryFilm/projet.service';

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})
export class MainPageComponent implements OnInit {
  projetList: Projet[] = [];

  projet: Projet | undefined;

  constructor(private router: Router,
              private projetService: ProjetService) {
  }

  ngOnInit(): void {
    /*
        this.projetService.getProjetList()
          .subscribe(projetList => projetList.forEach(projectId => {
            this.projetService.getProjetById(projectId.id)
              .subscribe(projet => {
                if (projet != undefined) {
                  this.projetList.push(projet)
                }
              })
          })); //je m'abonne au flux de donnée de l'observable pour recevoir une liste de film
        //quand je reçois la liste de film je la pousse dans filmList
        this.projetList?.forEach(projet => this.projetService.getProjetById(projet.id))
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

      SupprimerProjet(projet :Projet){
        this.projetService.deleteProjetById(projet.id).subscribe( );
      }
    */
    fetch(`http://localhost:8080/project/`).then(res => res.json())
      .then(jsonData => {
        console.log(jsonData);
        return this.projetList = jsonData;
      });
  }
}
