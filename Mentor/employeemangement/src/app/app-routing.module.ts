import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllUserInfoActionComponent } from './Components/all-user-info-action/all-user-info-action.component';

const routes: Routes = [
  {path:"userinfo", component:AllUserInfoActionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
