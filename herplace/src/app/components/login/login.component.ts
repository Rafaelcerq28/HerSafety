import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { UserService } from '../../service/user.service';
import { AuthenticationService } from '../../service/authentication.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterOutlet,RouterLink,RouterLinkActive],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(private router:Router,private userService: UserService, private authenticationService: AuthenticationService){
    //Clear the session storage to force a reload in the user page
    sessionStorage.clear();
  }
  
  user:any = null;

  username: string = '';
  password: string = '';
  alerMsg: boolean = false;

  test() {
    console.log(this.user)
  }

  login() {
    //initialize the message to false before the search for the user begin
    this.alerMsg = false;

    this.authenticationService.login(this.username, this.password).subscribe({
      next: () => {
        //Store the user in the local storage
        this.userService.setUser(JSON.parse(localStorage.getItem('user') || '{}'));
        this.user = this.userService.getUser();
  
        //Check is the user was found and return a message if not
        if (!this.user) {
          this.alerMsg = true;
        } else {
          this.alerMsg = false;

          this.router.navigate(['/user/'], { queryParams: { username: this.username } });
        }
      },
      error: err => {
        console.error("error during the login: ", err);
        this.alerMsg = true;
      }
    });
  }
  


}
