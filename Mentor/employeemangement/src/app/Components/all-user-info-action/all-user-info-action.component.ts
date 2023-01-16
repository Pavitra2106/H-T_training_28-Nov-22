import { Component, OnInit } from '@angular/core';
import User from 'src/app/Entity/User';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-all-user-info-action',
  templateUrl: './all-user-info-action.component.html',
  styleUrls: ['./all-user-info-action.component.css']
})
export class AllUserInfoActionComponent implements OnInit {

    id: number=0;
    firstname: String='';
    lastname: String='';
    email: String='';
    username: String='';
    role: String='';

  user :User = new User();
  update() {

  }
  delete() {

  }
  constructor(private userService: UserServiceService) { }

  ngOnInit(): void {
  }

}
