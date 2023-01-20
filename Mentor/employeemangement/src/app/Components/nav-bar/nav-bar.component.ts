import { Component, OnInit } from '@angular/core';
import { TokenstorageService } from 'src/app/Service/tokenstorage.service';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {
  
  private roles: string;
  isLoggedIn = false;
  showAdmin = false;
  showUser = false;
  username?: string;

  

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokendata.getToken();

    if (this.isLoggedIn) {
      const user = this.tokendata.getUsername();
      this.roles = this.tokendata.getUserRole();
     // alert("yourrole11 "+this.tokendata.getUserRole());
      //  alert("yourrole "+this.roles);
      this.showAdmin = this.roles.includes('manager');
     // alert("yourrole "+this.showAdmin);   
      this.showUser = this.roles.includes('user');
      //alert("showUser "+this.showUser);   
      this.username = user;
      //alert("user "+this.username);   
    }
  }
  logout(): void {
    //alert("yourrole ");
    this.tokendata.signOut();
    window.location.reload();
  }
  constructor(private tokendata :TokenstorageService) { }
}
