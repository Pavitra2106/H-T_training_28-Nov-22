import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import User from 'src/app/Entity/User';
import { TokenstorageService } from 'src/app/Service/tokenstorage.service';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  onSubmit(data: any) {
    console.log(data);
}
title:String = "please fill the form below"
user : User = new User();

login() {
  //console.log("hello" +this.user.username + " " +this.user.password);
  const observables = this.userService.saveUser
  (this.user);
  observables.subscribe (
    (response:any) => {
      console.log(response);
      sessionStorage.setItem('role',response.role)
      window.sessionStorage.setItem('ID',response.id)
      this.tokendata.saveToken(response.jwtToken);
        this.tokendata.saveUser(response.role,response.id,response.username);
      alert("Successfully login");
      //alert("Successfully "+response.role );
      //alert("Successfully2 "+response.id );
      //alert("Successfully3 "+response.username);
      if(response.user !=''){
        this.router.navigateByUrl('')

      }
    }, function(error) {
      console.log(error);
      alert("Something went wrong, Please try again!")
    }
  )
}

public SignupRedirect(){
  this.router.navigateByUrl('/signupform')
}

constructor(private userService : UserServiceService ,private router:Router , private tokendata :TokenstorageService) { }

  ngOnInit(): void {
  }

}
