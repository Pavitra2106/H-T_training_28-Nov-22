import { Component, OnInit } from '@angular/core';
import { UserServiceService } from 'src/app/Service/user-service.service';
import Employee from 'src/app/Entity/employee';

@Component({
  selector: 'app-all-emp-list',
  templateUrl: './all-emp-list.component.html',
  styleUrls: ['./all-emp-list.component.css']
})
export class AllEmpListComponent implements OnInit {

  constructor(private userservice : UserServiceService) { }
  employee :Employee[]=[];
  ngOnInit(): void {
    const promise = this.userservice.getemployee();
    promise.subscribe((response) =>{
      console.log(response);
      this.employee =response as Employee[];
    })
  }

}
