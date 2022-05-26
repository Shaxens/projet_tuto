// @ts-ignore
import { NgModule } from "@angular/core";
import {IvyCarouselModule} from 'angular-responsive-carousel';

// @ts-ignore
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
<<<<<<< HEAD
import { FormulaireFilmComponent } from './DirectoryFilm/formulaire-film/formulaire-film.component';
import { ListFilmComponent } from './Directory/list-film/list-film.component';
import { TousLesFilmsComponent } from './DirectoryFilm/tous-les-films/tous-les-films.component';
=======
import { FormulaireFilmComponent } from './formulaire-film/formulaire-film.component';
import { MainPageComponent } from "./main-page/main-page.component";
>>>>>>> ca64ba4fa6afe881f0babbfd97d9e069b74cc4be

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FormulaireFilmComponent,
<<<<<<< HEAD
    ListFilmComponent,
    TousLesFilmsComponent
=======
    MainPageComponent
>>>>>>> ca64ba4fa6afe881f0babbfd97d9e069b74cc4be
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    IvyCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
