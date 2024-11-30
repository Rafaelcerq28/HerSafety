import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { GoogleMapsModule } from '@angular/google-maps';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DatePipe } from '@angular/common';
import { catchError } from 'rxjs/operators';
import { of } from 'rxjs';

import { PlaceService } from '../../service/place.service';
import { Report } from '../../Report';
import { Place } from '../../Place';
import { ReportService } from '../../service/report.service';
import { ThisReceiver } from '@angular/compiler';
import { SearchonplaceComponent } from "../searchonplace/searchonplace.component";
import { UserService } from '../../service/user.service';


CommonModule
@Component({
  selector: 'app-place',
  standalone: true,
  imports: [CommonModule, GoogleMapsModule, FormsModule, RouterOutlet, RouterLink, RouterLinkActive, DatePipe, SearchonplaceComponent],
  templateUrl: './place.component.html',
  styleUrl: './place.component.css'
})
export class PlaceComponent {

  constructor(private route: ActivatedRoute,private placeService: PlaceService,private reportService: ReportService, private userService:UserService,private router:Router) {
    this.initMap(); 
    this.user = this.userService.getUser();
     
    //call the method to get a place in the constructor 
    this.getPlace();
  }

  //http param
  name:string = '';

  //initial position to update the map
  lat:number = 53.3489292;
  lng:number = -6.2429928;

  //defines the center of the map
  center: google.maps.LatLngLiteral = { lat: this.lat, lng: this.lng };
  zoom: number = 20;
  markerPosition: google.maps.LatLngLiteral = { lat: this.lat, lng: this.lng };

// Vatiables
  place?: any;
  reports: Report[] = [];
  reportMetric?: any;
  user?:any;
  safetyTips?:any;
  searchPlace:string = "";

  //method to get a place
  getPlace(){
    //Variable to Store the name from the search component
    let name:string = '';
    let id:number = -1;
    
    //Get name from the search
    this.route.queryParams.subscribe(params => {
      name = params['name']});   

    //check is the name exists
    if(name == undefined){
        id = Number(this.route.snapshot.paramMap.get("name"));
        if(Number.isNaN(id)){
          name = String(this.route.snapshot.paramMap.get("name"));
        }
    }    

    //check if the name is empty or undefined, if not, call the service to get a place
    if(name != "null" && name != undefined){
      this.placeService.getPlace(name).subscribe((place) => {
        this.place = place
        this.getReport(this.place.id);
        this.getReportMetrics(this.place.id);
        this.initMap();
      });
      
      //GET SAFETY TIPS
      if(this.user != null){
        this.safetyTips = this.getSafetyTips(); 
      }

    }else{
      //FIND BY ID
      // Call the getPlaceById method from placeService and pass the place ID as a string
      this.placeService.getPlaceById(String(id)).pipe(
        // Use catchError to handle any errors that may occur in the request
        catchError((error) => {
          // Check if the error status is 404 (not found)
          if (error.status === 404) {
            // Log an error message to the console indicating the place was not found
            console.error("Place not found (404)");
            // Set the place variable to null to indicate the place wasn't found
            this.place = null;
          }
          // Return an observable that emits null to keep the stream alive
          return of(null);
        })
      ).subscribe((place) => { // Subscribe to the observable to process the result or handle the error
        // If the place is found and not null
        if (place) {
          // Assign the received place data to the component's place variable
          this.place = place;
          // Call getReport with the place ID to fetch associated reports
          this.getReport(this.place.id);
          // Call getReportMetrics with the place ID to fetch metric data
          this.getReportMetrics(this.place.id);
          // Log the report metrics to the console for debugging
          console.log(this.reportMetric);
          // Initialize the map with the place data
          this.initMap();

          // GET SAFETY TIPS
          if(this.user != null){
            this.safetyTips = this.getSafetyTips(); 
          }

        } else {
          // If the place is null, log a message indicating the place was not loaded
          console.log("Place not loaded due to error.");
        }
      });
        
    }

  }

  //method to get reports
  getReport(id:number){
    this.reportService.getReport(id).subscribe((reports) => {
      this.reports = reports

    });
  }

  //method to get metrics
  getReportMetrics(id:number){
    this.reportService.getReportMetrics(id).subscribe((data:any) => {
      this.reportMetric = data;
    });
  }

//Method to get safety tips from the user based on the users preference
getSafetyTips(){
  this.userService.getSafetyTips(this.user.username).subscribe((safetyTips) => {
    this.safetyTips = safetyTips;
  });
}

//initialize the google map
  initMap():void{
    this.center = { lat: Number(this.place?.lat), lng: Number(this.place?.lng) };
    this.markerPosition = { lat: Number(this.place?.lat), lng: Number(this.place?.lng) };
    this.zoom = 20;
  }

  //method to denounce a user report
  reportReport(report:string,reportId:number,placeId:number,placeName:string,message:string){
    const reportedReport:any = null;
    this.reportService.reportReport(report,reportId,placeId,this.user.username,placeName,message).subscribe((reportedReport) => {
      reportedReport = reportedReport;
    });
  }

  //method to make a report (redirect to the report page)
  makeReport(placeId:number){
    this.router.navigate(['/report/'],{ queryParams: {placeId:placeId}})

  }

  //SEARCH BAR METHOD
  //This method redirects to the redirect compoment, and once in the redirect component 
  //it is redirected to place component again 
  search(search:string){
    search = search.split(' ').join('+');
    this.router.navigate([`/redirect/`],{ queryParams: {name: search}});
  }

  ngOnInit() {

  }
}
