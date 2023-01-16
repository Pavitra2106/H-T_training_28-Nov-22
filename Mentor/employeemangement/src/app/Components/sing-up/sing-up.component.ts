import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sing-up',
  templateUrl: './sing-up.component.html',
  styleUrls: ['./sing-up.component.css']
})
export class SingUpComponent implements OnInit {
  onSubmit(data: any) {
    console.log(data);

  }

  signup : Signup = new Signup();

  submit() {
    const observables = this.userService.saveSignup
    (this.signup);
    observables.subscribe (
      (response:any) => {
        console.log(response);
        alert("submitted Successfully");
      }, function(error) {
        console.log(error);
        alert("Something went wrong, Please try again!")
      }
    )
  }

  constructor() { }

  ngOnInit(): void {
  }

}
