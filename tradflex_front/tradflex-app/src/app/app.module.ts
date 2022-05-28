// @ts-ignore
import { NgModule } from "@angular/core";
import {IvyCarouselModule} from 'angular-responsive-carousel';
// @ts-ignore
import { BrowserModule } from "@angular/platform-browser";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { TousLesProjetsComponent } from './DirectoryFilm/tous-les-projets/tous-les-projets.component';
import { FormulaireProjetComponent } from './DirectoryFilm/formulaire-projet/formulaire-projet.component';
import { MainPageComponent } from "./main-page/main-page.component";
import {HttpClientModule} from "@angular/common/http";
import {HttpClientInMemoryWebApiModule} from "angular-in-memory-web-api";
import { InMemoryDataService} from "./in-memory-data.service";
import { ParametreProjetComponent } from "./DirectoryFilm/parametre-projet/parametre-projet.component";

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FormulaireProjetComponent,

    TousLesProjetsComponent,
    MainPageComponent,
    ParametreProjetComponent

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
