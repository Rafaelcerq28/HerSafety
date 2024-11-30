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

  //variables
  user?:any | null;
  users?:any;
  metrics?: any | undefined;
  ReportedReports?:any | null;

  //method to get all users
  getAllUsers(){
    this.userService.getAllUsers().subscribe((users) => {
      this.users = users;
    });
  }

  //method to update the active status
  updateActiveStatus(username:string){
    let strReturn: any;
    this.userService.updateActiveStatus(username).subscribe((strReturn) => {
      strReturn = strReturn;
      this.getAllUsers();
    });
    
  }

  //method to get the reported messages
  getReportedReports(){
    this.reportService.getReportedReports().subscribe((ReportedReports) => {
      this.ReportedReports = ReportedReports;
    });
    console.log(this.ReportedReports);
  }
  
  //method to keep a comment (remove from the reported list but keep the comment in the place)
  keepComment(reportId:number){
    this.reportService.keepComment(reportId).subscribe((httpReturn) => {
      httpReturn = httpReturn;
      this.getReportedReports();
    });
    
  }
  
  //method to delete a comment (delete from the list and from the place)
  deleteComment(reportId:number){
    this.reportService.deleteComment(reportId).subscribe((httpReturn) => {
      httpReturn = httpReturn;
      this.getReportedReports();
    });
  }

  //method to get metrics
  getMetrics(){
    this.reportService.getMetrics().subscribe((metrics) =>{
      this.metrics = metrics;
    });
  }


}
