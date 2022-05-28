import { Component, OnInit } from '@angular/core';
import { Projet } from '../../projet';
@Component({
  selector: 'app-ajout-projet',
  template: `
    <h2 class="center">Ajouter un projet</h2>
    <app-formulaire-projet [projet]="projet"></app-formulaire-projet>
  `
})export class AjoutProjetComponent implements OnInit {

  projet : Projet|undefined;

  ngOnInit(): void {  this.projet = new Projet();
  }

}





