import { Component, OnInit } from '@angular/core';

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

save(){

  console.log('Hello ' + this.Firstname +" "+this.Lastname);
  console.log('your email ' + this.email);
}
  constructor() { }

  ngOnInit(): void {
  }

}
