import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { User } from '../User';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  private apiUrl : string = "http://localhost:8080";
  
  // login(username: string, password: string) {
  //   this.httpClient.post<any>(this.apiUrl, { username, password })
  //     .subscribe(response => {
  //       const user = response
  //       // Armazena o token no Local Storage
  //       localStorage.setItem('user', JSON.stringify(user));        
  //       // JSON.parse(localStorage.getItem('user') || '{}');
  //     });
  // }

  login(username: string, password: string): Observable<any> {
    return this.httpClient.post<any>(`${this.apiUrl}/login`, { username, password }).pipe(
      tap(response => {
        // Armazena o usuário no Local Storage
        localStorage.setItem('user', JSON.stringify(response));
      })
    );
  }
  
  //finish this
  register(user:User): Observable<any>{
    return this.httpClient.post<any>(`${this.apiUrl}/users`, user).pipe(
      tap(response => {
        // Armazena o usuário no Local Storage
        localStorage.setItem('user', JSON.stringify(response));
      })
    );
  }

}
