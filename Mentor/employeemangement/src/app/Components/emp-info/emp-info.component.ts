import { Component, OnInit } from '@angular/core';
import Employee from 'src/app/Entity/employee';
import { TokenstorageService } from 'src/app/Service/tokenstorage.service';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-emp-info',
  templateUrl: './emp-info.component.html',
  styleUrls: ['./emp-info.component.css']
})
export class EmpInfoComponent implements OnInit {
  currentUserId: any;
  constructor(private userservice : UserServiceService, private tokendata: TokenstorageService) { }
  employee :Employee[]=[];
  ngOnInit(): void {
    this.currentUserId = this.tokendata.getUserId();
    const promise = this.userservice.getemployeebyid(this.currentUserId);
    promise.subscribe((response) =>{
      console.log(response);
      this.employee =response as Employee[];
    })
  }

}
