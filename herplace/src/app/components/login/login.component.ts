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

  constructor(private router:Router,private userService: UserService, private authenticationService: AuthenticationService){}

  user:any = null;

  username: string = '';
  password: string = '';
  alerMsg: boolean = false;

  test() {
    console.log(this.user)
  }

  // login() {
  //   // this.user = this.userService.clearUser 
  //   this.authenticationService.login(this.username,this.password);
  //   this.userService.setUser(JSON.parse(localStorage.getItem('user') || '{}'));
  //   this.user = this.userService.getUser();

  //   if((this.user === null) == true ){
  //     this.alerMsg = "User not found"
  //   }else{
  //     this.alerMsg = "Good"
  //     this.router.navigate(['/user/'],{ queryParams: {username: this.username, password:this.password}});
  //   }

  //   console.log('Usuario recuperado:', this.user);
  //   console.log(this.user === null)
  //   // 
  // }

  login() {
    //initialize the msg to false before the search for the user begin
    this.alerMsg = false;

    this.authenticationService.login(this.username, this.password).subscribe({
      next: () => {
        // Agora que o login foi concluído, você pode buscar o usuário do Local Storage
        this.userService.setUser(JSON.parse(localStorage.getItem('user') || '{}'));
        this.user = this.userService.getUser();
  
        // Verifica se o usuário foi encontrado e navega ou exibe uma mensagem de erro
        if (!this.user) {
          this.alerMsg = true;
        } else {
          this.alerMsg = false;
          this.router.navigate(['/user/'], { queryParams: { username: this.username } });
        }
      },
      error: err => {
        console.error("Erro ao fazer login:", err);
        this.alerMsg = true;
      }
    });
  }
  


}
