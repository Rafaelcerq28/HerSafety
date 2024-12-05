import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-searchonplace',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './searchonplace.component.html',
  styleUrl: './searchonplace.component.css'
})
export class SearchonplaceComponent {
  
  constructor(private router: Router){}

  searchPlace: string = "";


  transformToUrlFormat(name: string): string {

    return this.searchPlace.split(' ').join('+');
  }
  
  //Sending query to place page
  search(){
    const url = self;

    this.router.navigate(['/place/'],{ queryParams: {name:this.transformToUrlFormat(this.searchPlace)}});

  }
}
