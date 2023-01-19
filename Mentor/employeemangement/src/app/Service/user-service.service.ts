import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = 'http://localhost:9000';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {  
  saveSignup(user: {
    firstname: String
    lastname: String;
    username: String;
    password: String;
    email: String;
    role: String;
  }) {
   // alert("before service "+ user.email);
    return this.http.post(BASE_URL + "/signup", user);
  }
  
  saveUser(login: {
    username: String;
    password: String;
  }) {
    return this.http.post(BASE_URL + "/signin", login);
  }

  getUser() {
    return this.http.get(BASE_URL + "/allusers");
  }

  getUserbyid(id:number) {
    //alert("data userid " +id);
    return this.http.get(BASE_URL + "/getusersbyid/"+id);
  }

  Updateuser(
    id1:Number,
    firstname1: String,
    lastname1: String,
    email1: String,
  ) 
  {
    return this.http.get(BASE_URL + "/update/"+id1+"/"+firstname1+"/"+lastname1+"/"+email1);
  }

  deleteuser(id:Number) {
    //alert("before ~~~~"+ id);
    return this.http.delete(BASE_URL + "/delete/" +id);
  }
  getemployee() {
    return this.http.get(BASE_URL + "/getallemp");
  }

  createjobs(job: {
    jobname: String  ;
    startingtime: String ;
    endtime: String;
    profitvalue: Number ;
    applicablerole: String ;
    status: String  ;
    LocalDateTime: String ;
  }) {
   // alert("before service "+ job.jobname);
    return this.http.post(BASE_URL + "/createjobs", job);
  }

  getjoblist() {
    return this.http.get(BASE_URL + "/available/jobs");
  }
  Updatejob(
    id1:Number,
    jobname: String,
    startingtime: String,
    endtime: String,
    profitvalue: String,
    applicablerole: String,
    status: String
  ) 
  {//alert("before service"+ jobname);
    return this.http.get(BASE_URL + "/updatejob/"+id1+"/"+jobname+"/"+startingtime+"/"+endtime+"/"+profitvalue+"/"+applicablerole+"/"+status);
  }

  getempjoblist(applicablerole: String) {
    return this.http.get(BASE_URL + "/available/jobs/"+applicablerole);
  }
  
  startjob(job :{    
    id:Number;
    applicablerole: String;
    jobname: String;
  },userid: Number,
  status: String) 
  {
    // alert("data from token "  + userid);
    // alert("data from token id1 "  + startjob1.id);
     //alert("data from token status "  + status);
    // alert("data from token applicablerole "  + startjob1.applicablerole);
     //alert("data from token jobname "  + job.jobname);
    return this.http.put(BASE_URL + "/updateJobAndSalary/user/"+userid+"/"+status, job);
  }
  completedjob(job :{    
    id:Number;
    applicablerole: String;
    profitvalue: String;
  },userid: Number,
  status: String) 
  {
    // alert("data from token "  + userid);
    //  alert("data from token status "  + status);
    // alert("data from token applicablerole "  + job.applicablerole);
    //  alert("data from token jobname "  + job.profitvalue);
    return this.http.put(BASE_URL + "/updateJobAndSalary/user/"+userid+"/"+status, job);
  }

  abortedjob(job :{    
    id:Number;
    applicablerole: String;
  },userid: Number,
  status: String) 
  {
    // alert("data from token "  + userid);
    //  alert("data from token status "  + status);
    // alert("data from token applicablerole "  + job.applicablerole);
    return this.http.put(BASE_URL + "/updateJobAndSalary/user/"+userid+"/"+status, job);
  }
  Updateuserrole(user:{
    role:String;
  },userid: Number)
  {
    // alert("data from user.role "  + user.role);
    //  alert("data from  userid "  + userid);
    return this.http.get(BASE_URL + "/update/userrole/"+user.role+"/"+userid);
  }

  constructor(private http: HttpClient) { }
}
