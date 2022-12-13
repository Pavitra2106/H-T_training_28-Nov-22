
 function myfuction() {
     alert("In JS ");
     let x = document.forms["myForm"]["firstname"].value;
     if (x == "") {
       alert("Name must be filled out");
       return false;
     }
     let y = document.forms["myForm"]["dob"].value;
     if (y == "") {
       alert("DOB must be filled out");
       return false;
     }
     let z = document.forms["myForm"]["email"].value;
     if (z == "") {
       alert("Email must be filled out");
       return false;
     }
     let a = document.forms["myForm"]["mobNumber"].value;
     if (a == "") {
       alert("Mob Number must be filled out");
       return false;
     }
     let b = document.forms["myForm"]["gender"].value;
     if (b == "---") {
       alert("Gender  must be filled out");
       return false;
     }
     let c = document.forms["myForm"]["occupation"].value;
     if (c == "") {
       alert("Occupation  must be filled out");
       return false;
     }
     let d = document.forms["myForm"]["id"].value;
     if (d == "") {
       alert("Id Type must be filled out");
       return false;
     }
     let e = document.forms["myForm"]["idno"].value;
     if (e == "") {
       alert("ID Number must be filled out");
       return false;
     }
     let f = document.forms["myForm"]["issueAuth"].value;
     if (f == "") {
       alert("Issue Authority must be filled out");
       return false;
     }
     let g = document.forms["myForm"]["issueDate"].value;
     if (g == "") {
       alert("Issue Date must be filled out");
       return false;
     }
     let h= document.forms["myForm"]["issueState"].value;
     if (h == "") {
       alert("Issue State must be filled out");
       return false;
     }
     let i = document.forms["myForm"]["expriydate"].value;
     if (i == "") {
       alert("Expriy Date must be filled out");
       return false;
     }
     window.location.href="ThankYou.html";
 }