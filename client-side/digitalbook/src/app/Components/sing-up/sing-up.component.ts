import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/user';
import { UserService } from 'src/app/Service/user.service';

@Component({
  selector: 'app-sing-up',
  templateUrl: './sing-up.component.html',
  styleUrls: ['./sing-up.component.css']
})
export class SingUpComponent implements OnInit {

  firstName: String  ='';
  lastName : String ='';
  emailId : String ='';
  password: String ='';
  passwordConfirm: String ='';
  roles:Boolean =true;
  
  user: User = new User();
  
  save() {
    if (this.user.firstName == "") {
      alert("User First Name is Null");
      return;
    }
    if (this.user.lastName == "") {
      alert("User Last Name is Null");
      return;
    }
    if (this.user.emailId == "") {
      alert("Email is Null");
      return;
    }
    if (this.user.password == "") {
      alert("Password is Null");
      return;
    }
    if (this.user.passwordConfirm == "") {
      alert("Password Confirm is Null");
      return;
    }
    if (this.user.roles==null) {
      alert("Role is Null");
      return;
    }
    const observables = this.userService.singup(this.user);
    observables.subscribe(
      (response: any) => {
        console.log(response);
        alert(" You have Successfully registed");
       }, function (error: any) {
        console.log(error);
        alert("something went wrong, Please try again!")
      })
     this.user.firstName='';
     this.user.lastName='';
     this.user.emailId='';
     this.user.password='';
     this.user.passwordConfirm="";
     this.user.roles=false;
  }
  constructor(private userService: UserService) { }

  ngOnInit(): void {
  }

}
