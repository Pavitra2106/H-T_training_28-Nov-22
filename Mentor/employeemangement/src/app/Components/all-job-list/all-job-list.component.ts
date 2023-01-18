import { Component, OnInit } from '@angular/core';
import Job from 'src/app/Entity/job';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-all-job-list',
  templateUrl: './all-job-list.component.html',
  styleUrls: ['./all-job-list.component.css']
})
export class AllJobListComponent implements OnInit {

  constructor(private userservice : UserServiceService) { }
  job :Job[]=[];
  ngOnInit(): void {
    const promise = this.userservice.getjoblist();
    promise.subscribe((response) =>{
      console.log(response);
      this.job =response as Job[];
    })
  }

}
