import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { GoogleMapsModule } from '@angular/google-maps';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

CommonModule
@Component({
  selector: 'app-place',
  standalone: true,
  imports: [CommonModule,GoogleMapsModule,FormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './place.component.html',
  styleUrl: './place.component.css'
})
export class PlaceComponent {

  constructor(private route: ActivatedRoute) {
    this.initMap();
  }
//http param
  name:string = '';

  latitude = "";
  longitude ="";

  lat:number = 53.3489292;
  lng:number = -6.2429928;

  //define o centro do mapa
  center: google.maps.LatLngLiteral = { lat: this.lat, lng: this.lng };
  zoom: number = 20;
  markerPosition: google.maps.LatLngLiteral = { lat: this.lat, lng: this.lng };

  initMap():void{
    console.log("vrum");
    this.center = { lat: this.lat, lng: this.lng };
    this.markerPosition = { lat: this.lat, lng: this.lng };
    this.zoom = 20;
  }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.name = params['name'];
      // Aqui você pode fazer a lógica de pesquisa com base no 'query'
      console.log('Termo de busca:', this.name);
      //CRIAR O OBJETO PLACE E A SERVICE
    });
  }
}
