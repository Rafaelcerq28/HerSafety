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
  private apiUrl : string = "https://herplace-app-9b31336a84d5.herokuapp.com";

  editSecurityInfo(username:string, q1:string, q2:string, q3:string, q4:string, q5:string):Observable<any>{
    return this.httpClient.put<any>(`${this.apiUrl}/users/securityinfo/${username}`,
      {
        question1:q1,
        question2:q2,
        question3:q3,
        question4:q4,
        question5:q5
      });
  }

  getSafetyTips(username:string):Observable<any>{
    console.log("o metodo foi acionado no service:)");
    return this.httpClient.get(`${this.apiUrl}/safety/${username}`, { responseType: 'text' });
  }
  
  getSecurityInfo(username:string):Observable<any>{
    return this.httpClient.get<any>(`${this.apiUrl}/users/securityinfo/${username}`);
  }

  getAllUsers():Observable<any>{
    return this.httpClient.get<any[]>(`${this.apiUrl}/users`);
  }

  updateActiveStatus(username:string):Observable<any>{
    return this.httpClient.put<any>(`${this.apiUrl}/users/status/${username}`,{});
  }

}
