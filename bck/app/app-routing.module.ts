import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateBookComponent } from './Components/create-book/create-book.component';
import { HomepageComponent } from './Components/homepage/homepage.component';
import { SearchBookComponent } from './Components/search-book/search-book.component';
import { SingInComponent } from './Components/sing-in/sing-in.component';
import { SingUpComponent } from './Components/sing-up/sing-up.component';

const routes: Routes = [{path:"",component:HomepageComponent},
{path:"create", component:CreateBookComponent},
{path:"search", component:SearchBookComponent},
{path:"singin", component:SingInComponent},
{path:"singup", component:SingUpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
