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

  constructor(private userService: UserService, private reportService: ReportService){
    // Verifica se a página já foi recarregada nesta sessão
    const hasReloaded = sessionStorage.getItem('hasReloaded');

    if (!hasReloaded) {
      // Armazena o estado de recarregamento no sessionStorage para evitar loops
      sessionStorage.setItem('hasReloaded', 'true');
      
      // Recarrega a página apenas uma vez
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
        // this.edit = true
      }
      console.log(this.securityInfo)
    })
  }

  saveSecurityOption(){
    this.editSecurityInfo()
  }

//Event to get the selected item 
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

  // showSelectionQ1(){
  //   this.editQ1 = !this.editQ1;
  // }
  // showSelectionQ2(){
  //   this.editQ2 = !this.editQ2;
  // }
  // showSelectionQ3(){
  //   this.editQ3 = !this.editQ3;
  // }
  // showSelectionQ4(){
  //   this.editQ4 = !this.editQ4;
  // }
  // showSelectionQ5(){
  //   this.editQ5 = !this.editQ5;
  // }

  getReport(username:string){
    this.reportService.getReportByUser(username).subscribe((reports) => {
      this.reports = reports
      console.log("Reports " + this.reports);
    });
  }
}
