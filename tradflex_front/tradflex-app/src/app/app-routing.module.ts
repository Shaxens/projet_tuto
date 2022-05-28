import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormulaireProjetComponent } from './DirectoryFilm/formulaire-projet/formulaire-projet.component';
import { ParametreProjetComponent } from './DirectoryFilm/parametre-projet/parametre-projet.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  { path: 'accueil', component: MainPageComponent },
  { path: 'creerProjet', component: FormulaireProjetComponent },
  //{ path: 'editer/:id', component: ParametreProjetComponent }, // Component à modifier plus tard pour pouvoir editer un fichier (sous-titre / film)
  { path: 'parametre/:id', component: ParametreProjetComponent }, // Permet de modifier un titre, une description, un statut ou une image
  { path: '', redirectTo: 'accueil', pathMatch: 'full' }
];

@NgModule({
  "imports": [RouterModule.forRoot(routes)],
  "exports": [RouterModule]
})
export class AppRoutingModule { }
