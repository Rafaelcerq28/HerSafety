import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { UserService } from '../../service/user.service';
import { ReportService } from '../../service/report.service';

@Component({
  selector: 'app-moderator',
  standalone: true,
  imports: [CommonModule,RouterLink,RouterLinkActive],
  templateUrl: './moderator.component.html',
  styleUrl: './moderator.component.css'
})
export class ModeratorComponent {

  constructor(private userService: UserService, private reportService: ReportService){
    this.user = this.userService.getUser();
    this.getAllUsers();
    this.getReportedReports();
    this.getMetrics();
  }

  user?:any | null;
  users?:any;
  metrics?: any | undefined;
  ReportedReports?:any | null;

  getAllUsers(){
    this.userService.getAllUsers().subscribe((users) => {
      this.users = users;
      // console.log(this.users);
    });
  }

  updateActiveStatus(username:string){
    let strReturn: any;
    this.userService.updateActiveStatus(username).subscribe((strReturn) => {
      strReturn = strReturn;
      this.getAllUsers();
    });
    
  }

  getReportedReports(){
    this.reportService.getReportedReports().subscribe((ReportedReports) => {
      this.ReportedReports = ReportedReports;
    });
    console.log(this.ReportedReports);
  }
  
  keepComment(reportId:number){
    this.reportService.keepComment(reportId).subscribe((httpReturn) => {
      httpReturn = httpReturn;
      this.getReportedReports();
    });
    
  }
  
  deleteComment(reportId:number){
    this.reportService.deleteComment(reportId).subscribe((httpReturn) => {
      httpReturn = httpReturn;
      this.getReportedReports();
    });
  }

  getMetrics(){
    this.reportService.getMetrics().subscribe((metrics) =>{
      this.metrics = metrics;
      console.log(metrics);
    });
  }


}
