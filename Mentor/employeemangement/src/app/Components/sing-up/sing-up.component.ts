import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import User from 'src/app/Entity/User';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-sing-up',
  templateUrl: './sing-up.component.html',
  styleUrls: ['./sing-up.component.css']
})
export class SingUpComponent implements OnInit {
  onSubmit(data: any) {
    console.log(data);
  }
  user : User = new User();
  submit() {
   // alert("before "+ this.user.email);
    const observables = this.userservice.saveSignup(this.user);
    observables.subscribe (
      (response:any) => {
        console.log(response);
        alert("submitted Successfully");
        if(response.id !=''){
          this.router.navigateByUrl('login')
  
        }
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      }
    )
  }
  constructor(private userservice : UserServiceService,private router:Router) { }
  ngOnInit(): void {}

}
