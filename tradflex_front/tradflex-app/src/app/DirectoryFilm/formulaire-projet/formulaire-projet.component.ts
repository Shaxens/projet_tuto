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

constructor(
  private projetService: ProjetService,
  private router: Router,


) { }

  ngOnInit(): void {

  }
  onSubmit(){
  console.log('Submit form');

  }
}
