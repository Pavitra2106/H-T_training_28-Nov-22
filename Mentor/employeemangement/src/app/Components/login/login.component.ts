import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import User from 'src/app/Entity/User';
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

save() {
  //console.log("hello" +this.user.username + " " +this.user.password);
  const observables = this.userService.saveUser
  (this.user);
  observables.subscribe (
    (response:any) => {
      console.log(response);
      sessionStorage.setItem('role',response.role)
      alert("Successfully login");
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

constructor(private userService : UserServiceService ,private router:Router ) { }

  ngOnInit(): void {
  }

}
