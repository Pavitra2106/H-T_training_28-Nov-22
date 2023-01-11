import { Component, OnInit } from '@angular/core';
import { ɵangular_packages_router_router_b } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
loggedin(){
  return localStorage.getItem('token');
}
loggedout(){
   localStorage.removeItem('token');
 }  
}
