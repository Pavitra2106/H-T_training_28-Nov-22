import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import Job from 'src/app/Entity/job';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-usercreatejob',
  templateUrl: './usercreatejob.component.html',
  styleUrls: ['./usercreatejob.component.css']
})
export class UsercreatejobComponent implements OnInit {
  onSubmit(data: any) {
    console.log(data);
  }
  job : Job = new Job();
  submit() { 
     //alert("before "+ this.job.startingtime);
    const observables = this.userservice.createjobs(this.job);
    observables.subscribe (
      (response:any) => {
        console.log(response);
        alert("submitted Successfully");
        if(response.id !=''){
          this.router.navigateByUrl('joblist')
  
        }
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      }
    )


  }
  constructor(private userservice : UserServiceService,private router:Router) { }

  ngOnInit(): void {
  }

}
