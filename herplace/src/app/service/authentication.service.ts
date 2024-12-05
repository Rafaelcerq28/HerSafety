import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { User } from '../User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  private apiUrl : string = "https://herplace-app-989c0538b8f0.herokuapp.com";
  
  login(username: string, password: string): Observable<any> {
    return this.httpClient.post<any>(`${this.apiUrl}/login`, { username, password }).pipe(
      tap(response => {
        // Store the user in the local storage
        localStorage.setItem('user', JSON.stringify(response));
      })
    );
  }
  
  register(user:User): Observable<any>{
    return this.httpClient.post<any>(`${this.apiUrl}/users`, user).pipe(
      tap(response => {
        // Store the user in the local storage
        localStorage.setItem('user', JSON.stringify(response));
      })
    );
  }

}
