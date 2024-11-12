import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet, Router} from '@angular/router';

import { Report } from '../../Report';
import { ReportService } from '../../service/report.service';

@Component({
  selector: 'app-makereport',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterOutlet, RouterLink, RouterLinkActive],
  templateUrl: './makereport.component.html',
  styleUrl: './makereport.component.css'
})
export class MakereportComponent {

constructor(private route:ActivatedRoute){
  this.route.queryParams.subscribe(params => {
    this.placeId = params['placeId']});

  console.log(this.placeId);
}

placeId:number = 0;
}
