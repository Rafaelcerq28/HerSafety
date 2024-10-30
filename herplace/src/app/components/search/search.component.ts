import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet , Router} from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PlaceComponent } from '../place/place.component';

@Component({
  selector: 'app-search',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,RouterLinkActive,FormsModule],
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  constructor(private router: Router){}

  searchPlace: string = "";


  transformToUrlFormat(name: string): string {
    return this.searchPlace.split(' ').join('+');
  }
  
  //Sending query to place page
  search(){
    
    this.router.navigate(['/place/'],{ queryParams: {name:this.transformToUrlFormat(this.searchPlace)}});
  }

}
