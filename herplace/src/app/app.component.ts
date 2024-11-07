import { Component } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { HomeComponent } from "./components/home/home.component";
import { FooterComponent } from "./components/footer/footer.component";
import { PlaceComponent } from "./components/place/place.component";
import { UserService } from './service/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterLink,RouterLinkActive, HomeComponent, FooterComponent, PlaceComponent,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  user?:any = null;

  constructor(private userService: UserService){
    this.user = this.userService.getUser();
    console.log(this.user)  
  }

  logout():void{
    this.userService.clearUser();
    location.reload();
  }

  title = 'herplace';
}
