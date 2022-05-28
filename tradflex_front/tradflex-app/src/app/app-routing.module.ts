import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditProjetComponent } from './DirectoryFilm/edit-projet/edit-projet.component';
import { FormulaireProjetComponent } from './DirectoryFilm/formulaire-projet/formulaire-projet.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  { path: 'accueil', component: MainPageComponent },
  { path: 'creerProjet', component: FormulaireProjetComponent },
  { path: 'modifier/:id', component: EditProjetComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' }
];

@NgModule({
  "imports": [RouterModule.forRoot(routes)],
  "exports": [RouterModule]
})
export class AppRoutingModule { }
