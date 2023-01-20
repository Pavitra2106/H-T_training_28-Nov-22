import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Job from 'src/app/Entity/job';
import { TokenstorageService } from 'src/app/Service/tokenstorage.service';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-job-select',
  templateUrl: './job-select.component.html',
  styleUrls: ['./job-select.component.css']
})
export class JobSelectComponent implements OnInit {
  isStart = true;
  isCompleted = false;
  isaborted = false;

  id:Number =this.route.snapshot.params['id'];
  jobname: String=this.route.snapshot.params['jobname'];
  startingtime: String=this.route.snapshot.params['startingtime'];
  endtime: String=this.route.snapshot.params['endtime'];
  profitvalue: Number=this.route.snapshot.params['profitvalue'];
  applicablerole: String=this.route.snapshot.params['applicablerole'];
  status: String=this.route.snapshot.params['status'];
  
  
  currentUserId: any;
  jobstaus:any;
  constructor(private userservice : UserServiceService , private tokendata :TokenstorageService,
    private route :ActivatedRoute,private router:Router) { }
 
job: Job =new Job();

  ngOnInit(): void {
    if (this.status=="inprogress"){
      this.isStart=false;
      this.isCompleted = true;
      this. isaborted = true;
    }
    if (this.status=="completed"){
      this.isStart=false;
      this.isCompleted = false;
      this. isaborted = false;
      //alert("Job Already Completed");
    }

    if (this.status=="aborted"){
      this.isStart=false;
      this.isCompleted = false;
      this. isaborted = false;
      alert("Job Aborted Action Not Allowed");
    }
  }
  instart(){
    this.job.id=this.id;
    this.job.applicablerole=this.applicablerole;
    this.job.jobname=this.jobname;
    this.currentUserId = this.tokendata.getUserId();
    this.jobstaus="inprogress"
    const observables = this.userservice.startjob(this.job,this.currentUserId,this.jobstaus);
    observables.subscribe(
      (response:any) => {
        console.log(response);   
      alert("JOB Starting");
      this.isStart=false;
      this.isCompleted = true;
      this. isaborted = true;
      }, function(error) {
        console.log(error);
        alert("Job Time OverLapping")
        alert("Please complete you last job")
      })
  }
  completed(){
    this.job.id=this.id;
    this.job.applicablerole=this.applicablerole;
    this.job.profitvalue=this.profitvalue;
    this.currentUserId = this.tokendata.getUserId();
    this.jobstaus="completed"
    const observables = this.userservice.completedjob(this.job,this.currentUserId,this.jobstaus);     observables.subscribe(
      (response:any) => {
        console.log(response);   
     // this.job.splice(index,1);
      alert("JOB Completed");
      this.router.navigateByUrl('empjoblist')
    this.isStart=false;
    this.isCompleted = false;
    this. isaborted = false;
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      })
  }

  aborted(){
    this.job.id=this.id;
    this.job.applicablerole=this.applicablerole;

    this.currentUserId = this.tokendata.getUserId();
    this.jobstaus="aborted"
    const observables = this.userservice.abortedjob(this.job,this.currentUserId,this.jobstaus); //userid
    observables.subscribe(
      (response:any) => {
        console.log(response);   
     // this.job.splice(index,1);
      alert("JOB aborted  Please select the Job Again");
      this.router.navigateByUrl('empjoblist')
      
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      })
  }
  


}
