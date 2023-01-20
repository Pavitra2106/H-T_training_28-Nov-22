import { Component, OnInit } from '@angular/core';
import Job from 'src/app/Entity/job';
import { TokenstorageService } from 'src/app/Service/tokenstorage.service';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-all-empjob-list',
  templateUrl: './all-empjob-list.component.html',
  styleUrls: ['./all-empjob-list.component.css']
})
export class AllEmpjobListComponent implements OnInit {

  constructor(private userservice : UserServiceService , private tokendata :TokenstorageService) { }
  currentUserRole: any;
  
  job :Job[]=[];
  ngOnInit(): void {
    this.currentUserRole = this.tokendata.getUserRole();
    //alert("data from token "  + this.tokendata.getUserRole());
    const promise = this.userservice.getempjoblist(this.currentUserRole); 
        promise.subscribe((response) =>{
      console.log(response);
      this.job =response as Job[];
    },function(error) {
      console.log(error);
      alert("Something went wrong, Please try again!")
    })}
  
}
