// @ts-ignore
import { NgModule } from "@angular/core";

// @ts-ignore
import { BrowserModule } from "@angular/platform-browser";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule} from "@angular/forms";
import { FormulaireFilmComponent } from './formulaire-film/formulaire-film.component';

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    FormulaireFilmComponent
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
