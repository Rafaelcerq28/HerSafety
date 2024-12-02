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

  //Method to get the user report passing the place id
  getReport(id:number): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.apiUrl}/${id}`);  
  }

  //method to make a report
  makeReport(report:Report,username:string): Observable<any>{
    console.log(username);
    console.log(report)
    return this.httpClient.post(`http://localhost:8080/report/${username}`,report);  
  }

  //Method to get the report metrics
  getReportMetrics(id:number): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/metrics/${id}`); 
  }

  //Method to get the report by user
  getReportByUser(username:string): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`http://localhost:8080/report/user/${username}`);  
  }

  //Mehtod to report a comment
  reportReport(report:string,reportId:number,placeId:number,username:string,placeName:string,message:string): Observable<Report[]>{
    return this.httpClient.post<Report[]>(`http://localhost:8080/report/denounce/${report}/${reportId}/${placeId}/${username}`,
      {
      message:message,
      placeName:placeName
    });  
  }

  //Method to get reported reports
  getReportedReports(): Observable<any>{
    return this.httpClient.get(`http://localhost:8080/report/reported-reports`); 
  }

  //method to remove the reported comment from the list but keep the comment in the place
  keepComment(reportId:number): Observable<any>{
    console.log("keep comment (service)")
    return this.httpClient.delete(`http://localhost:8080/report/delete-reported/${reportId}`,{});

  }

  //Method to delete the comment from the list and from the post
  deleteComment(reportId:number): Observable<any>{
    return this.httpClient.delete(`http://localhost:8080/report/reported-comment/${reportId}`);
  }

  //method to get the system metrics
  getMetrics(): Observable<any>{
    return this.httpClient.get(`http://localhost:8080/metrics`);
  }
}
