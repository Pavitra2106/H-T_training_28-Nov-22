function myfuction() {
      //alert("Name");
      var x = document.getElementById("firstname").value;
       if (x == "") {
       alert("Name must be filled out");
       return false; 
     }
      var y = document.getElementById("dob").value;
      //alert("Name "+y);
     if (y == "") {
       alert("DOB must be filled out");
       return false;
     }
     var z = document.getElementById("email").value;
     if (z == "") {
       alert("Email must be filled out");
       return false;
     }
     var a = document.getElementById("mobNumber").value;
     if (a == "") {
       alert("Mob Number must be filled out");
       return false;
     }
     var b = document.getElementById("gender").value;
     if (b == "---") {
       alert("Gender  must be filled out");
       return false;
     }
     var c = document.getElementById("occupation").value;
     if (c == "") {
       alert("Occupation  must be filled out");
       return false;
     }
     var d = document.getElementById("id").value;
     if (d == "") {
       alert("Id Type must be filled out");
       return false;
     }
     var e = document.getElementById("idno").value;
     if (e == "") {
       alert("ID Number must be filled out");
       return false;
     }
     var f = document.getElementById("issueAuth").value;
     if (f == "") {
       alert("Issue Authority must be filled out");
       return false;
     }
     var g = document.getElementById("issueDate").value;
     if (g == "") {
       alert("Issue Date must be filled out");
       return false;
     }
     var h = document.getElementById("issueState").value;
     if (h == "") {
       alert("Issue State must be filled out");
       return false;
     }
     var i = document.getElementById("expriydate").value;
     if (i == "") {
       alert("Expriy Date must be filled out");
       return false;
     }
    console.log("Name "+x);
    console.log("DOB "+y);
    console.log("Email "+z);
    console.log("MOB-Number "+a);
    console.log("Gender "+b);
    console.log("Occupation "+C);
    console.log("Id Type "+d);
    console.log("ID Number "+e);
    console.log("Issue Authority "+f);
    console.log("Issue Date "+g);
    console.log("Issue State "+h);
    console.log("ExpriyDate "+i);
    alert("You Data is submmiting....");
     window.open('ThankYou.html');
    }