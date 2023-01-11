import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import User from 'src/app/Entity/user';
import { UserService } from 'src/app/Service/user.service';

@Component({
  selector: 'app-sing-in',
  templateUrl: './sing-in.component.html',
  styleUrls: ['./sing-in.component.css']
})
export class SingInComponent implements OnInit {
  emailId : String ='';
  password: String ='';
  user: User = new User();
  onLogin() {
    if (this.user.emailId == "") {
      alert("Email is Null");
      return;
    }
    if (this.user.password == "") {
      alert("Password is Null");
      return;
    }
    const observables = this.userService.authUser(this.user);
    observables.subscribe(
      (response: any) => {
        localStorage.setItem('valid', response.id);
        console.log(response);
        this.router.navigate(['']);
        alert(" You have Successfully Log-In");
       }, function (error: any) {
        console.log(error);
        alert("something went wrong, Please try again!")
      })
  }
  constructor(private userService: UserService,
    private router :Router) { }

  ngOnInit(): void {
  }

}
