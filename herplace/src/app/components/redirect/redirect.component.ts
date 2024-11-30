import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-redirect',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,RouterLinkActive,FormsModule],
  templateUrl: './redirect.component.html',
  styleUrl: './redirect.component.css'
})
export class RedirectComponent {
constructor(private route: ActivatedRoute,private router:Router){
  //Get the name and redirect again to place
  this.route.queryParams.subscribe(params => {
    this.name = params['name'];
  });

  this.name = this.name.split(' ').join('+')
  this.router.navigate(['/place/'],{ queryParams: {name: this.name}});
}

name:string = "";

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.name = params['name'];
      
    });
  }
}
