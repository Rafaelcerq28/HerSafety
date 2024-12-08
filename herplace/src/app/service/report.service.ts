import { Injectable } from '@angular/core';
import { Report } from '../Report';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private httpClient: HttpClient) {}

  apiUrl = 'https://herplace-app-989c0538b8f0.herokuapp.com'

  //Method to get the user report passing the place id
  getReport(id:number): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.apiUrl}/report/place/${id}`);  
  }

  //method to make a report
  makeReport(report:Report,username:string): Observable<any>{
    console.log(username);
    console.log(report)
    return this.httpClient.post(`${this.apiUrl}/report/${username}`,report);  
  }

  //Method to get the report metrics
  getReportMetrics(id:number): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/report/place/metrics/${id}`); 
  }

  //Method to get the report by user
  getReportByUser(username:string): Observable<Report[]>{
    return this.httpClient.get<Report[]>(`${this.apiUrl}/report/user/${username}`);  
  }

  //Mehtod to report a comment
  reportReport(report:string,reportId:number,placeId:number,username:string,placeName:string,message:string): Observable<Report[]>{
    return this.httpClient.post<Report[]>(`${this.apiUrl}/report/denounce/${report}/${reportId}/${placeId}/${username}`,
      {
      message:message,
      placeName:placeName
    });  
  }

  //Method to get reported reports
  getReportedReports(): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/report/reported-reports`); 
  }

  //method to remove the reported comment from the list but keep the comment in the place
  keepComment(reportId:number): Observable<any>{
    console.log("keep comment (service)")
    return this.httpClient.delete(`${this.apiUrl}/report/delete-reported/${reportId}`,{});

  }

  //Method to delete the comment from the list and from the post
  deleteComment(reportId:number): Observable<any>{
    return this.httpClient.delete(`${this.apiUrl}/report/reported-comment/${reportId}`);
  }

  //Method to delete a report 
  deleteReport(reportId:number): Observable<any>{
    return this.httpClient.delete(`${this.apiUrl}/report/${reportId}`);
  }

  //method to get the system metrics
  getMetrics(): Observable<any>{
    return this.httpClient.get(`${this.apiUrl}/metrics`);
  }
}
