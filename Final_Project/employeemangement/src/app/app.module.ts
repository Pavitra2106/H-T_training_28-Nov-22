import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { SingUpComponent } from './Components/sing-up/sing-up.component';
import { NavBarComponent } from './Components/nav-bar/nav-bar.component';
import { FooterComponent } from './Components/footer/footer.component';

import { AllUserComponent } from './Components/all-user/all-user.component';
import { UsercreatejobComponent } from './Components/usercreatejob/usercreatejob.component';
import { AllUserInfoActionComponent } from './Components/all-user-info-action/all-user-info-action.component';
import { HomeComponent } from './Components/home/home.component';
import { AllEmpListComponent } from './Components/all-emp-list/all-emp-list.component';
import { AllJobListComponent } from './Components/all-job-list/all-job-list.component';
import { JobUpdateComponent } from './Components/job-update/job-update.component';
import { AllEmpjobListComponent } from './Components/all-empjob-list/all-empjob-list.component';
import { UpdateRoleComponent } from './Components/update-role/update-role.component';
import { EmpInfoComponent } from './Components/emp-info/emp-info.component';
import { JobSelectComponent } from './Components/job-select/job-select.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SingUpComponent,
    NavBarComponent,
    FooterComponent,
    AllUserComponent,
    UsercreatejobComponent,
    AllUserInfoActionComponent,
    HomeComponent,
    AllEmpListComponent,
    AllJobListComponent,
    JobUpdateComponent,
    AllEmpjobListComponent,
    UpdateRoleComponent,
    EmpInfoComponent,
    JobSelectComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }