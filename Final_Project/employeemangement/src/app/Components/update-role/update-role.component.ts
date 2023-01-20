import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import User from 'src/app/Entity/User';
import { TokenstorageService } from 'src/app/Service/tokenstorage.service';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-update-role',
  templateUrl: './update-role.component.html',
  styleUrls: ['./update-role.component.css']
})
export class UpdateRoleComponent implements OnInit {
  id:Number = this.route.snapshot.params['id'];
  
  constructor(private userService: UserServiceService,private tokendata :TokenstorageService,
    private route :ActivatedRoute ,private router:Router) { }
      user: User =new User();

  ngOnInit(): void {
  
  }
  updaterole(){ 
    const observables = this.userService.Updateuserrole(this.user,this.id);
    observables.subscribe (
      (response:any) => {
        console.log(response);
        alert("Role Update Successfully");
        if(response.role !=''){
          alert("Role "+this.user.role);
          this.router.navigateByUrl('alluser')
  
        }
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      }
    )}


}
