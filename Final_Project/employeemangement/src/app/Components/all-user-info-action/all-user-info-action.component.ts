import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import User from 'src/app/Entity/User';
import { UserServiceService } from 'src/app/Service/user-service.service';
import { ActivatedRoute,Route,ParamMap } from '@angular/router';
import { HttpParams } from '@angular/common/http';

@Component({
  selector: 'app-all-user-info-action',
  templateUrl: './all-user-info-action.component.html',
  styleUrls: ['./all-user-info-action.component.css']
})
export class AllUserInfoActionComponent implements OnInit {
    id:Number =this.route.snapshot.params['id'];
    firstname: String=this.route.snapshot.params['firstname'];
    lastname: String=this.route.snapshot.params['lastname'];
    email: String=this.route.snapshot.params['email'];
     user :User = new User();
  update() {
    if(this.firstname==''){
    alert("First Name is Null ");

    }
    if(this.lastname==''){
    alert("First Name is Null ");
  }
  if(this.email==''){
    alert("Email is Null ");
  }
     const observables = this.userService.Updateuser(this.id,this.firstname,this.lastname,this.email);
     observables.subscribe (
       (response:any) => {
         console.log(response);
         alert("Update Successfully");
       }, function(error) {
         console.log(error);
         alert("Update Failed, Please try again!")
       }
     )
   }
   delete (){
   // alert("before "+ this.id);
    const observables = this.userService.deleteuser(this.id);
    observables.subscribe(
      (response:any) => {
        console.log(response);   
      alert(this.firstname +" User Data Deleting");
      this.router.navigateByUrl('alluser')
      },function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      })
  }
  constructor(private userService: UserServiceService,private router:Router ,
    private route :ActivatedRoute) { }
 
    //selectedid:any=0;
    //userdata :User[]=[];
  ngOnInit(): void {
    // this.selectedid= this.route.snapshot.params['id'];
    // id:Number =this.route.snapshot.params['id'];
    //     //alert("data userid " +this.selectedid);
    // const promise = this.userService.getUserbyid(this.selectedid);
    // promise.subscribe((response) =>{
    //   console.log(response);
    //   this.userdata =response as User[];
      
    // })
  }
}
