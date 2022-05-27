// @ts-ignore
import { NgModule } from "@angular/core";
import {IvyCarouselModule} from 'angular-responsive-carousel';
// @ts-ignore
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { TousLesFilmsComponent } from './DirectoryFilm/tous-les-films/tous-les-films.component';
import { FormulaireFilmComponent } from './DirectoryFilm/formulaire-film/formulaire-film.component';
import { MainPageComponent } from "./main-page/main-page.component";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientInMemoryWebApiModule} from "angular-in-memory-web-api";
import { InMemoryDataService} from "./in-memory-data.service";
import { EditProjetComponent } from './DirectoryFilm/edit-projet/edit-projet.component';

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FormulaireFilmComponent,

    TousLesFilmsComponent,
    MainPageComponent,
    EditProjetComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,//declaration de l'api simuler pour pouvoir l'utiliser dans tout l'application
    HttpClientInMemoryWebApiModule.forRoot( InMemoryDataService ,{dataEncapsulation : false}),
    AppRoutingModule,
    IvyCarouselModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
