import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutLibraryComponent } from './Components/about-library/about-library.component';
import { BookAddComponent } from './Components/book-add/book-add.component';
import { GetDeleteComponent } from './Components/get-delete/get-delete.component';
import { HomeComponent } from './Components/home/home.component';

const routes: Routes = [{path:"",component:HomeComponent},
{path:"addbook", component:BookAddComponent},
{path:"getbook", component:GetDeleteComponent},
{path:"aboutlibrary", component:AboutLibraryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
