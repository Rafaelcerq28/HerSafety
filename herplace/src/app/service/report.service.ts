import { Injectable } from '@angular/core';
import { Report } from '../Report';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private httpClient: HttpClient) {}

  apiUrl = 'http://localhost:8080/report/place'

  getReport(id:number): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.apiUrl}/${id}`);  
    // return this.httpClient.get<Report>;
  }

  makeReport(report:Report,username:string): Observable<any>{
    console.log(username);
    console.log(report)
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

  //REPORT A REPORT
  reportReport(report:string,reportId:number,placeId:number,username:string,placeName:string,message:string): Observable<Report[]>{
    return this.httpClient.post<Report[]>(`http://localhost:8080/report/denounce/${report}/${reportId}/${placeId}/${username}`,
      {
      message:message,
      placeName:placeName
    });  
  }

  getReportedReports(): Observable<any>{
    return this.httpClient.get(`http://localhost:8080/report/reported-reports`); 
  }

  keepComment(reportId:number): Observable<any>{
    console.log("keep comment (service)")
    return this.httpClient.delete(`http://localhost:8080/report/delete-reported/${reportId}`,{});

  }

  deleteComment(reportId:number): Observable<any>{
    return this.httpClient.delete(`http://localhost:8080/report/reported-comment/${reportId}`);
  }

  getMetrics(): Observable<any>{
    return this.httpClient.get(`http://localhost:8080/metrics`);
  }
}
