import { Injectable } from '@angular/core';
import { Report } from '../Report';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private httpClient: HttpClient) { }

  apiUrl = 'http://localhost:8080/report/place'

  getReport(id:number): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.apiUrl}/${id}`);  
    // return this.httpClient.get<Report>;
  }

  getReportMetrics(id:number): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/metrics/${id}`); 
  }

  getReportByUser(username:string): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`http://localhost:8080/report/user/${username}`);  
    // return this.httpClient.get<Report>;
  }
}
