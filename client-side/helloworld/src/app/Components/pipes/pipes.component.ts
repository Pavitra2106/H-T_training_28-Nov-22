import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.css']
})
export class PipesComponent implements OnInit {

employee ={
  "name":"Rohit Pandey",
  "BaseSalary":9009990,
  "JoinedOn":Date.now(),
  "Qualification":"Btech",
  "About":"He is Very good employ, he best employees are constantly looking for new ways to improve themselves and contribute more to the company. They listen, take feedback seriously and are open minded when presented with new ideas. They aren't afraid to ask questions and seek help when needed",
  "WinningPrecentage":35/100
}

  constructor() { }

  ngOnInit(): void {
  }

}
