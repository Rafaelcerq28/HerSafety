import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { User } from '../../User';
import { AuthenticationService } from '../../service/authentication.service';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  constructor(private router:Router, private authenticationService: AuthenticationService, private userService: UserService){}

  name:string = '';
  username: string = '';
  password: string = '';
  email:string = '';
  date: any | undefined;
  notifications: boolean = false;
  user:any = null;

  //method to register a new user
  register(){
    var newUser: User = {
      name: this.name,
      username: this.username,
      password:this.password,
      email: this.email,
      dateOfBirth: this.date,
      notifications: this.notifications,
      createdAt:''
    }
    console.log(newUser);
    
    this.authenticationService.register(newUser).subscribe({
      next: () => {
        //after the register the user is logged in and can be found in the localstorage
        this.userService.setUser(JSON.parse(localStorage.getItem('user') || '{}'));
        this.user = this.userService.getUser();
  
        //check if the user was found
        if (!this.user) {
          console.log("fail")
        } else {

          this.router.navigate(['/user/'], { queryParams: { username: this.username } });
        }
      },
      error: err => {
        console.error("Erro ao fazer login:", err);
      }
    });

    
  }

}
