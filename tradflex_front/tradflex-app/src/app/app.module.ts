// @ts-ignore
import { NgModule } from "@angular/core";

// @ts-ignore
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { FormulaireFilmComponent } from './DirectoryFilm/formulaire-film/formulaire-film.component';
import { ListFilmComponent } from './Directory/list-film/list-film.component';
import { TousLesFilmsComponent } from './DirectoryFilm/tous-les-films/tous-les-films.component';

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FormulaireFilmComponent,
    ListFilmComponent,
    TousLesFilmsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
