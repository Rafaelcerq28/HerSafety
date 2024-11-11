import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { GoogleMapsModule } from '@angular/google-maps';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { DatePipe } from '@angular/common';

import { PlaceService } from '../../service/place.service';
import { Report } from '../../Report';
import { Place } from '../../Place';
import { ReportService } from '../../service/report.service';
import { ThisReceiver } from '@angular/compiler';
import { SearchonplaceComponent } from "../searchonplace/searchonplace.component";


CommonModule
@Component({
  selector: 'app-place',
  standalone: true,
  imports: [CommonModule, GoogleMapsModule, FormsModule, RouterOutlet, RouterLink, RouterLinkActive, DatePipe, SearchonplaceComponent],
  templateUrl: './place.component.html',
  styleUrl: './place.component.css'
})
export class PlaceComponent {

  constructor(private route: ActivatedRoute,private placeService: PlaceService,private reportService: ReportService) {
    this.initMap(); 
    
    //metodo para pegar a localização  
    this.getPlace();
  }
  
//http param
  name:string = '';

  //lat / long inicial e para update
  latitude = "";
  longitude ="";

  lat:number = 53.3489292;
  lng:number = -6.2429928;

  //define o centro do mapa
  center: google.maps.LatLngLiteral = { lat: this.lat, lng: this.lng };
  zoom: number = 20;
  markerPosition: google.maps.LatLngLiteral = { lat: this.lat, lng: this.lng };

// TESTING API GET
  place?: Place;
  reports: Report[] = [];
  reportMetric?: any;

  getPlace(){
    //Variable to Store the name from the search component
    let name:string = '';

    //Get name from the search
    this.route.queryParams.subscribe(params => {
      name = params['name']});   
    // Store the name in a variable (maybe delete the line below later)
    // const name = String(this.route.snapshot.paramMap.get("name"));

    if(name == undefined){
      name = String(this.route.snapshot.paramMap.get("name"));
      console.log("passou aq " + name);
    }


    console.log("nome no get: " + name);
    
    if(name != "null"){
      this.placeService.getPlace(name).subscribe((place) => {
        this.place = place
        this.getReport(this.place.id);
        this.getReportMetrics(this.place.id);
        console.log(this.reportMetric);
        this.initMap();
      });
    }
  }

  getReport(id:number){
    this.reportService.getReport(id).subscribe((reports) => {
      this.reports = reports
      // console.log(this.reports);
    });
  }

  getReportMetrics(id:number){
    this.reportService.getReportMetrics(id).subscribe((data:any) => {
      this.reportMetric = data;
    });
  }
// END TESTING API GET

//initialize the google map
  initMap():void{
    console.log("vrum");
    this.center = { lat: Number(this.place?.lat), lng: Number(this.place?.lng) };
    this.markerPosition = { lat: Number(this.place?.lat), lng: Number(this.place?.lng) };
    this.zoom = 20;
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.name = params['name'];
      // Aqui você pode fazer a lógica de pesquisa com base no 'query'
    });
  }
}
