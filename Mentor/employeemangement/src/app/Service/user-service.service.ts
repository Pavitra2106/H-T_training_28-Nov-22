import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

const BASE_URL = 'http://localhost:9000/';
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  getUser() {
    return this.http.get(BASE_URL + "/allusers");
  }
  constructor(private http: HttpClient) { }
}
