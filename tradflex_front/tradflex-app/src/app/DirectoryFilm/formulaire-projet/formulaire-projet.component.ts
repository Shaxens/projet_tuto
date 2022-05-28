import {Component, Input, OnInit} from '@angular/core';
import { Projet } from '../../projet';
import {ProjetService} from "../projet.service";
import {Router} from "@angular/router";
@Component({
  selector: 'app-formulaire-projet',
  templateUrl: 'formulaire-projet.component.html',
  styleUrls: ['formulaire-projet.component.css']
})
export class FormulaireProjetComponent implements OnInit {

  @Input() projet: Projet|undefined;
  isAddForm: boolean|undefined;
constructor(
  private projetService: ProjetService,
  private router: Router,

) { }

  ngOnInit(): void {
  this.isAddForm = this.router.url.includes('add');//si l'url contient add j ajoute un projet sinon je modifie
  }
  onSubmit(){
  //console.log('Submit form');
    if(this.isAddForm){
    this.projetService.addProjet(this.projet).subscribe();
    }else {
      this.projetService.updateProjet(this.projet).subscribe()
    }
  }
}
