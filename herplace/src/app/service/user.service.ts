import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  //Methods to save the user in the localStorage
  private userKey = 'user';

  setUser(user: any): void {
    try{
      localStorage.setItem(this.userKey, JSON.stringify(user));
    }catch (error){
      console.log("error when acessing the local storage",error);
    }
  }

  getUser(): any {
    try{
      const user = localStorage.getItem(this.userKey);
      return user ? JSON.parse(user) : null;
    }catch (error){
      console.log("error when acessing the local storage",error);
      return null;
    }
  }

  clearUser(): void {
    localStorage.removeItem(this.userKey);
  }
  
  //method to get security info
  private apiUrl : string = "http://localhost:8080/users/securityinfo"

  editSecurityInfo(username:string, q1:string, q2:string, q3:string, q4:string, q5:string):Observable<any>{
    return this.httpClient.put<any>(`${this.apiUrl}/${username}`,{q1,q2,q3,q4,q5});
  }

  getSecurityInfo(username:string):Observable<any>{
    return this.httpClient.get<any>(`${this.apiUrl}/${username}`);
  }
}
