import { Component, OnInit } from '@angular/core';
import Job from 'src/app/Entity/job';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-all-empjob-list',
  templateUrl: './all-empjob-list.component.html',
  styleUrls: ['./all-empjob-list.component.css']
})
export class AllEmpjobListComponent implements OnInit {

  constructor(private userservice : UserServiceService) { }
  job :Job[]=[];
  ngOnInit(): void {
    const promise = this.userservice.getempjoblist("user");
    promise.subscribe((response) =>{
      console.log(response);
      this.job =response as Job[];
    })
  }
  instart(job: any, index: number){
    // const observables = this.userservice.deleteBook(job);
    // observables.subscribe(
    //   (response:any) => {
    //     console.log(response);   
    //   this.job.splice(index,1);
    //   alert(job.bookName+" Book Deleting");
    //   })
  }

  completed(job: any, index: number){
    // const observables = this.userservice.deleteBook(job);
    // observables.subscribe(
    //   (response:any) => {
    //     console.log(response);   
    //   this.job.splice(index,1);
    //   alert(job.bookName+" Book Deleting");
    //   })
  }

  aborted(job: any, index: number){
    // const observables = this.userservice.deleteBook(job);
    // observables.subscribe(
    //   (response:any) => {
    //     console.log(response);   
    //   this.job.splice(index,1);
    //   alert(job.bookName+" Book Deleting");
    //   })
  }
  

}
