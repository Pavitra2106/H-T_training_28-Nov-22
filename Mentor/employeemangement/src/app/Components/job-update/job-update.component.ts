import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Job from 'src/app/Entity/job';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-job-update',
  templateUrl: './job-update.component.html',
  styleUrls: ['./job-update.component.css']
})
export class JobUpdateComponent implements OnInit {
  onSubmit(data: any) {
    console.log(data);
  }
  id:Number =this.route.snapshot.params['id'];
  jobname: String=this.route.snapshot.params['jobname'];
  startingtime: String=this.route.snapshot.params['startingtime'];
  endtime: String=this.route.snapshot.params['endtime'];
  profitvalue: String=this.route.snapshot.params['profitvalue'];
  applicablerole: String=this.route.snapshot.params['applicablerole'];
  status: String=this.route.snapshot.params['status'];

  job : Job = new Job();
  submit(){
   alert("before "+ this.jobname);
   const observables = this.userService.Updatejob
   (this.id,this.jobname,this.startingtime,this.endtime,
    this.profitvalue,this.applicablerole,this.status);
   observables.subscribe (
     (response:any) => {
       console.log(response);
       alert("Update Successfully");
     }, function(error) {
       console.log(error);
      // alert("Update Something" +error);
       alert("Something went wrong, Please try again!")
     }
   )
 

  }
  constructor(private userService: UserServiceService,private router:Router ,
    private route :ActivatedRoute) { }

  ngOnInit(): void {
  }

}
