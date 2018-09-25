import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {HeaderComponent} from './header/header.component';
import {FooterComponent} from './footer/footer.component';
import {RouterModule, Routes} from "@angular/router";
import {MainComponent} from './main/main.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const appRoutes: Routes = [
  {path: '', component: MainComponent},
  {path: 'main', component: MainComponent},
  {path: 'page-not-found', component: PageNotFoundComponent},
  {path: '**', redirectTo: '/page-not-found'
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule, RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

