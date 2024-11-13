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

  makeReport(report:Report,username:string): Observable<any>{
    console.log(username);
    return this.httpClient.post(`http://localhost:8080/report/${username}`,report);  
    // return this.httpClient.get<Report>;
  }

  getReportMetrics(id:number): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/metrics/${id}`); 
  }

  getReportByUser(username:string): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`http://localhost:8080/report/user/${username}`);  
    // return this.httpClient.get<Report>;
  }

  reportReport(report:string,placeId:number,username:string): Observable<Report[]>{
    return this.httpClient.post<Report[]>(`http://localhost:8080/report/denounce/${report}/${placeId}/${username}`,{});  
  }
}
