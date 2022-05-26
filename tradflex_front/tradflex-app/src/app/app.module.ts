// @ts-ignore
import { NgModule } from "@angular/core";
import {IvyCarouselModule} from 'angular-responsive-carousel';

// @ts-ignore
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { FormulaireFilmComponent } from './formulaire-film/formulaire-film.component';
import { MainPageComponent } from "./main-page/main-page.component";

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FormulaireFilmComponent,
    MainPageComponent
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
