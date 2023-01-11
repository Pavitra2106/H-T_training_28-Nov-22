import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './Components/homepage/homepage.component';
import { SingUpComponent } from './Components/sing-up/sing-up.component';
import { SingInComponent } from './Components/sing-in/sing-in.component';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { SearchBookComponent } from './Components/search-book/search-book.component';
import { CreateBookComponent } from './Components/create-book/create-book.component';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { UserService } from './Service/user.service';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    SingUpComponent,
    SingInComponent,
    NavBarComponent,
    SearchBookComponent,
    CreateBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  FormsModule,
  HttpClientModule
  ],
  providers: [
    UserService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
