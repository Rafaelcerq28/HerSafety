import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet, Router} from '@angular/router';

import { Report } from '../../Report';
import { ReportService } from '../../service/report.service';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-makereport',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './makereport.component.html',
  styleUrl: './makereport.component.css'
})
export class MakereportComponent {



constructor(private route:ActivatedRoute,private userService:UserService, private reportService: ReportService,private router:Router){
  this.route.queryParams.subscribe(params => {
    this.placeId = params['placeId']});

    this.user = this.userService.getUser();

    
}

user?:any;
report:any = {};

placeId:number = 0;

safetyScore: number = 5;
cozyScore: number = 5;
toiletsScore: number = 5;
feminineProdScore: number = 5;
illuminationScore: number = 5;
crowdQualityScore: number = 5;
privacyScore: number = 5;
safetyInfoScore: number = 5;
textArea: string = '';

makeReport(){
  console.log(this.user.name);
  this.report.placeId = this.placeId;
  this.report.safety = this.safetyScore;
  this.report.welcoming = this.cozyScore;
  this.report.toilets = this.toiletsScore;
  this.report.feminineProducts = this.feminineProdScore;
  this.report.illumination = this.illuminationScore;
  this.report.crowdQuality = this.crowdQualityScore;
  this.report.privacy = this.privacyScore;
  this.report.safetyInfoScore = this.safetyInfoScore;
  this.report.comment = this.textArea;

  this.reportService.makeReport(this.report,this.user.username).subscribe((reportPost) => {
    this.report = reportPost;
  });
  this.router.navigate([`/place/${this.placeId}`]);
  console.log(this.report.createdAt);
}

}
