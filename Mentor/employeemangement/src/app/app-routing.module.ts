import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllEmpListComponent } from './Components/all-emp-list/all-emp-list.component';
import { AllEmpjobListComponent } from './Components/all-empjob-list/all-empjob-list.component';
import { AllJobListComponent } from './Components/all-job-list/all-job-list.component';
import { AllUserInfoActionComponent } from './Components/all-user-info-action/all-user-info-action.component';
import { AllUserComponent } from './Components/all-user/all-user.component';
import { HomeComponent } from './Components/home/home.component';
import { JobUpdateComponent } from './Components/job-update/job-update.component';
import { LoginComponent } from './Components/login/login.component';
import { SingUpComponent } from './Components/sing-up/sing-up.component';
import { UpdateRoleComponent } from './Components/update-role/update-role.component';
import { UsercreatejobComponent } from './Components/usercreatejob/usercreatejob.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"SignUp", component:SingUpComponent},
  {path:"login", component:LoginComponent},
  {path:"userinfo/:id/:firstname/:lastname/:email", component:AllUserInfoActionComponent},
  {path:"alluser", component:AllUserComponent},
  {path:"allEmp", component:AllEmpListComponent} ,
  {path:"jobadd", component:UsercreatejobComponent} ,
  {path:"joblist", component:AllJobListComponent},
  {path:"updatejob/:id/:jobname/:startingtime/:endtime/:profitvalue/:applicablerole/:status", component:JobUpdateComponent},
  {path:"empjoblist", component:AllEmpjobListComponent},
  {path:"updaterole/:id", component:UpdateRoleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
