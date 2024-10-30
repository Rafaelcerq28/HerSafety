import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { GoogleMapsModule } from '@angular/google-maps';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

import { PlaceService } from '../../service/place.service';
import { Place } from '../../Place';



CommonModule
@Component({
  selector: 'app-place',
  standalone: true,
  imports: [CommonModule,GoogleMapsModule,FormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './place.component.html',
  styleUrl: './place.component.css'
})
export class PlaceComponent {

  constructor(private route: ActivatedRoute,private placeService: PlaceService) {
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
  getPlace(){

    let nome:string = '';

    //pega o nome
    this.route.queryParams.subscribe(params => {
      nome = params['name']});   

    const name = String(this.route.snapshot.paramMap.get("name"));
    console.log("nome no get: " + nome);
    
    if(nome != "null"){
      this.placeService.getPlace(nome).subscribe((place) => (this.place = place));
      console.log(this.place);
    }

    this.initMap();
    
  }
// TESTING API GET
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
      console.log('Termo de busca:', this.name);
    });
  }
}
