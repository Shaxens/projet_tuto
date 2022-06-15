import { Component, OnInit } from '@angular/core';
import {Projet, ProjetId} from '../../projet';
import { ProjetService } from '../projet.service';
@Component({
  selector: 'app-tous-les-projets',
  templateUrl: './tous-les-projets.component.html',
  styleUrls: ['./tous-les-projets.component.css']
})
//cette class permet de recuperer les films
export class TousLesProjetsComponent implements OnInit {
projetList : ProjetId[] | undefined;
  constructor(private projetService : ProjetService) {
  }

  ngOnInit(): void {
    this.projetService.getProjetList()
      .subscribe(projetList => this.projetList = projetList);//je m'abonne au flux de donnée de l'observable pour recevoir une liste de film
    //quand je reçois la liste de film je la pousse dans filmList
    console.log(this.projetList)
  }
deleteProjet(projet :Projet){

    this.projetService.deleteProjetById(projet.id).subscribe( );
}

}
