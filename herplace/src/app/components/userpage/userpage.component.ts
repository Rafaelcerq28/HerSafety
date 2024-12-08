import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { UserService } from '../../service/user.service';
import { userInfo } from 'os';
import { ReportService } from '../../service/report.service';
import { Report } from '../../Report';

@Component({
  selector: 'app-userpage',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,RouterLinkActive,FormsModule],
  templateUrl: './userpage.component.html',
  styleUrl: './userpage.component.css'
})
export class UserpageComponent {
  question1 = '';
  question2 = '';
  question3 = '';
  question4 = '';
  question5 = '';

  reports: Report[] = [];
  user?:any = null;
  securityInfo?:any;

  successMessage: boolean = false;

  constructor(private userService: UserService, private reportService: ReportService){
    //check if the page was reloaded in this session
    const hasReloaded = sessionStorage.getItem('hasReloaded');
    
    if (!hasReloaded) {
      // Store the state to avoid loops
      sessionStorage.setItem('hasReloaded', 'true');
      
      // Reload the page
      this.reload();
    } else {
      this.user = this.userService.getUser();
      this.getSecurityInfo();
    }

    this.getReport(this.user.username);
  }

  reload():void{
    location.reload();
  }

  //Edit security info
  editSecurityInfo(){
    this.userService.editSecurityInfo(this.user.username,this.question1,this.question2,this.question3,this.question4,this.question5).subscribe((securityInfo) => {
      this.securityInfo = securityInfo;
      this.updateSuccessMessage();
    })
  }

  //Get securityInfo
  getSecurityInfo(){
    this.userService.getSecurityInfo(this.user.username).subscribe((securityInfo) => {
      this.securityInfo = securityInfo;
      
      if(securityInfo != null){
        this.question1 = securityInfo.question1;
        this.question2 = securityInfo.question2;
        this.question3 = securityInfo.question3;
        this.question4 = securityInfo.question4;
        this.question5 = securityInfo.question5;
      }else{
        
      }
    })
  }

  saveSecurityOption(){
    this.editSecurityInfo()
  }

  updateSuccessMessage(){
    this.successMessage = !this.successMessage;
  }

//Events to get the selected item 
  onSelectChange1(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question1  = target.value;
  }

  onSelectChange2(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question2  = target.value;
  }
  onSelectChange3(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question3  = target.value;
  }
  onSelectChange4(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question4  = target.value;
  }
  onSelectChange5(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question5  = target.value;
    console.log(this.user);
  }

  //method to get the reports
  getReport(username:string){
    this.reportService.getReportByUser(username).subscribe((reports) => {
      this.reports = reports
      console.log("Reports " + this.reports);
    });
  }

  deleteReport(reportId:number){
    this.reportService.deleteReport(reportId).subscribe((httpReturn) => {
      httpReturn = httpReturn;
      this.getReport(this.user.username);
    });
  }
}
