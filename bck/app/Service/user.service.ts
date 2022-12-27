import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = 'http://localhost:8002/api/v1/digitalbooks/';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  singup(user: {
    firstName: String ;
    lastName : String;
    emailId : String;
    password: String;
    passwordConfirm: String;
    roles:Boolean ;
  }) {
    return this.http.post(BASE_URL + "sign-up", user);
  }
  authUser(user: {

    emailId : String;
    password: String;
  }) {
    return this.http.post(BASE_URL + "sign-", user);
  }
  constructor(private http: HttpClient) { }
}
