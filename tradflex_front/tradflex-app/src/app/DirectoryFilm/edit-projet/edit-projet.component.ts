import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Projet } from '../../projet';
import { ProjetService } from '../projet.service';

@Component({
  selector: 'app-edit-projet',
  templateUrl: './edit-projet.component.html',
  styleUrls: ['./edit-projet.component.css']
})
export class EditProjetComponent implements OnInit {
  projet : Projet|undefined;
  constructor(private route: ActivatedRoute,
              private projetService : ProjetService)
  { }

  ngOnInit(): void {
    const projetId: string|null = this.route.snapshot.paramMap.get('id');
    if(projetId){
    this.projetService.getProjetById(+projetId)
    .subscribe(projet => this.projet = projet);
  } else {
  this.projet = undefined;
}
}

}
