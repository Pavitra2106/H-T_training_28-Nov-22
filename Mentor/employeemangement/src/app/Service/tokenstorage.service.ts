import { Injectable } from '@angular/core';

const TOKEN_KEY ='token';
const USER_KEY ='user';
const USER_ROLE ='role';
const USER_ID='id';
@Injectable({
  providedIn: 'root'
})
export class TokenstorageService {

  constructor() { }

  public saveToken(token: string): void {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }
  public saveUser(role: string,id: string, user: string): void {
    window.sessionStorage.removeItem(USER_ROLE);
    window.sessionStorage.setItem(USER_ROLE,role );
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, user);
    window.sessionStorage.removeItem(USER_ID);
    window.sessionStorage.setItem(USER_ID, id);
  }
  public getToken(): string | null {
    return window.sessionStorage.getItem(TOKEN_KEY);
  }
  public getUserRole(): any {
    const userrole = window.sessionStorage.getItem(USER_ROLE);
    //alert("data from token "  +userrole );
    if (userrole) {
      return userrole;
    }
      return {};
  }
  public getUserId(): any {
    const userid = window.sessionStorage.getItem(USER_ID);
    //alert("data from token "  +userrole );
    if (userid) {
      return userid;
    }
      return {};
  }
  public getUsername(): any {
    const username = window.sessionStorage.getItem(USER_KEY);
    //alert("data from token "  +userrole );
    if (username) {
      return username;
    }
      return {};
  }
  signOut(): void {
    window.sessionStorage.clear();
  }
}
