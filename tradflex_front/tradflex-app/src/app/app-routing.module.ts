import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormulaireFilmComponent } from './DirectoryFilm/formulaire-film/formulaire-film.component';
import { MainPageComponent } from './main-page/main-page.component';

const routes: Routes = [
  { path: 'accueil', component: MainPageComponent },
  { path: 'creerProjet', component: FormulaireFilmComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' }

];

@NgModule({
  "imports": [RouterModule.forRoot(routes)],
  "exports": [RouterModule]
})
export class AppRoutingModule { }
