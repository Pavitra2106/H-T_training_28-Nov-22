// var name="Pavitra Chaudhary"
// var age= 26;
// var city;
// city="noida";
// console.log(name);

// function callMe() {
//     alert("In JS "+ name);

// }
// callMe();
// function operators(num) {
//     if(num>20){
//         console.log("Number is greater than 20");
//     }
//         else if (num==20){
//             console.log("Number is equal to 20");  
//     }
//     else  {
//             console.log("Number is smaller than 20");  
//     }

// }
// operators(56);
// function Switchoperators(score) {
//     var limit;
//     switch(score){
//    case 700: limit="above 1 lac";
//    break;
//    case 700: limit="5000 to 10000";
//    break;
//    default : limit="not eligible";
//     }
//     console.log(limit);  
// }
// Switchoperators(700);

// function count(){
//     for (let i=1; i<10;i++){
//         console.log(i);  
//     }
// }
// count();

var car = new Object ();
car.brand="audi"
car.model="A4 class"
car.price= "90 Lakh"
console.log(car); 

var namelist = ["Pavitra", "Rahul", "Pranjul"]
console.log(namelist); 

class Car{
    constructor(brand, model, price){
        this.brand = brand;
        this.model=model;
        this.price=price;
    }
    print(){
        console.log("brand Name :"+ this.brand + ", model name: "+this.model +", price: " +this.price); 

    }
}
    var C1 = new Car("audi","A4 class","90 Lakh");
    C1.print();

    class TodaysDate extends Date {
        constructor(){
            super();
        }
        printDate(){
            console.log(this.getDate());
        }
    }
    let today = new TodaysDate();
    today.printDate();

    class Applelaptops{ 
        //parent class
        constructor(brand){
            this.brand= "Apple"

        }
    }
    class MacBook extends Applelaptops{
        //child class
        constructor(model,processor,ram){
            super();
            this.model= model;
            this.processor=processor;
            this.ram=ram;
        }
    }
     let l1 = new MacBook("2021 macbook", "M1", 16)
     console.log(l1.brand+" Brand name, "+ l1.model+ " Model name, "+l1.processor +" processor name,"
     +l1.ram+ " ram size ");

     let nameclassA = ["Pavitra", "Rahul", "Pranjul"]
     let nameclassB = ["Suraj", "vikash", "Rohan"]
      let Fullname= [ ...nameclassA, ...nameclassB]
     console.log(Fullname); 

     let counting =()=>{ //inline function or arrow function
         for (let i=1; i<10; i++)
         {
            console.log(i);   
         }
     }
     counting();


     var num1 =100;
     var num1 =200;
     console.log(num1);


     let a = 100;
     function addnum(){
         a=220;
       let b = 100;
       console.log(a+b);
     }

     addnum();
     console.log(a+1000);  

     function addnum1(){
         const num2 =222;
        // num2=120; we cna assing value to const variable again
        console.log(num2);
     }
     addnum1();

     function firstSubmit(){
         alert("Submit Function")
     }
    

