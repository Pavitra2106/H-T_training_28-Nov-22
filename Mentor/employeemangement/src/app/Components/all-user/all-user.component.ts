import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/User';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-all-user',
  templateUrl: './all-user.component.html',
  styleUrls: ['./all-user.component.css']
})
export class AllUserComponent implements OnInit {
  constructor(private userservice : UserServiceService) { }
  user :User[]=[];
  ngOnInit(): void {
    const promise = this.userservice.getUser();
    promise.subscribe((response) =>{
      console.log(response);
      this.user =response as User[];
    })
  }

}
