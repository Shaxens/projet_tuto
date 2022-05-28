import { Component, OnInit } from '@angular/core';
import { Projet } from '../../projet';
import { PROJET } from '../../projetList';
@Component({
  selector: 'app-formulaire-projet',
  templateUrl: 'formulaire-projet.component.html',
  styleUrls: ['formulaire-projet.component.css']
})
export class FormulaireProjetComponent implements OnInit {
film = new Projet(3,"jambon","yolo");
  constructor() { }

  ngOnInit(): void {
  }
  onSubmit(){
  console.log('Submit form');

  }
}
