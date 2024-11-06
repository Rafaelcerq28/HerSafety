import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  private apiUrl : string = "http://localhost:8080/login";
  
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
    return this.httpClient.post<any>(this.apiUrl, { username, password }).pipe(
      tap(response => {
        // Armazena o usuário no Local Storage
        localStorage.setItem('user', JSON.stringify(response));
      })
    );
  }
  
}
