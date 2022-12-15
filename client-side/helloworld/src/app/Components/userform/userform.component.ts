import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/User';

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
gender: String ='Male';
email:String = '';

user: User = new User ();

save(){

  console.log('Hello ' + this.user.Firstname +" "+this.user.Lastname);
  console.log('your email ' + this.user.email);
}
  constructor() { }

  ngOnInit(): void {
  }

}
