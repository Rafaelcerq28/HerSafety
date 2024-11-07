import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { User } from '../../User';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private authenticationService: AuthenticationService){}

  name:string = '';
  username: string = '';
  password: string = '';
  email:string = '';


  register(){
    var user: User = {
      name: this.name,
      username: this.username,
      password:this.password,
      email: this.email,
      dateOfBirth: '',
      notifications: false,
      createdAt:''
    }

    //finish this
    this.authenticationService.register(user)

    
  }

}
