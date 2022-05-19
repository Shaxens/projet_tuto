import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { WorkPageProjectComponent } from './work-page-project/work-page-project.component';

@NgModule({
  declarations: [
    AppComponent,
    WorkPageProjectComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
