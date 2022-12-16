import { Component, OnInit } from '@angular/core';
import { Subscriber } from 'rxjs';
import User from 'src/app/Entity/User';
import { UserService } from 'src/app/Services/user.service';

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
title: String ='Please fill the form below';
Firstname: String  ='';
Lastname : String ='';
age=0;
gender: String ='';
email:String = '';

user: User = new User ();
save(){
  const observables = this.userService.saveUser(this.user);
  observables.subscribe(
    (response:any) => {
      console.log(response);   
    }, function(error) {
      console.log(error);
      alert("something went wrong, Please try again!")
    })}
  constructor(private userService : UserService) {}
  ngOnInit(): void { }
}
