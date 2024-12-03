import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet , Router} from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PlaceComponent } from '../place/place.component';
import { PlaceService } from '../../service/place.service';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,RouterLinkActive,FormsModule],
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  constructor(private router: Router, private placeService:PlaceService){
    this.getPlaces();
  }

  searchPlace: string = "";
  places?:any | null;

  transformToUrlFormat(name: string): string {
    return this.searchPlace.split(' ').join('+');
  }
  
  //Sending query to place page
  search(){
    this.router.navigate(['/place/'],{ queryParams: {name:this.transformToUrlFormat(this.searchPlace)}});
  }

  getPlaces(){
    this.placeService.getAllPlaces().subscribe((places) => {
      this.places = places;
    });
  }

}
