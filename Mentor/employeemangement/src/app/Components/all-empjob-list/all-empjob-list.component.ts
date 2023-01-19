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
  currentUserId: any;
  jobstaus:any;
  job :Job[]=[];
  ngOnInit(): void {
    this.currentUserRole = this.tokendata.getUserRole();
    //alert("data from token "  + this.tokendata.getUserRole());
    const promise = this.userservice.getempjoblist(this.currentUserRole); 
        promise.subscribe((response) =>{
      console.log(response);
      this.job =response as Job[];
    },
    function(error) {
      console.log(error);
      alert("Something went wrong, Please try again!")
    }
    )

  }
  instart(job: any, index: number){
    this.currentUserId = this.tokendata.getUserId();
    this.jobstaus="inprogress"
    const observables = this.userservice.startjob(job,this.currentUserId,this.jobstaus); //userid
    observables.subscribe(
      (response:any) => {
        console.log(response);   
     // this.job.splice(index,1);
      alert("JOB Starting");
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      })
  }

  completed(job: any, index: number){
    this.currentUserId = this.tokendata.getUserId();
    this.jobstaus="completed"
    const observables = this.userservice.completedjob(job,this.currentUserId,this.jobstaus); //userid
    observables.subscribe(
      (response:any) => {
        console.log(response);   
     // this.job.splice(index,1);
      alert("JOB Completed");
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      })
  }

  aborted(job: any, index: number){
    this.currentUserId = this.tokendata.getUserId();
    this.jobstaus="aborted"
    const observables = this.userservice.abortedjob(job,this.currentUserId,this.jobstaus); //userid
    observables.subscribe(
      (response:any) => {
        console.log(response);   
     // this.job.splice(index,1);
      alert("JOB aborted");
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      })
  }
  

}
