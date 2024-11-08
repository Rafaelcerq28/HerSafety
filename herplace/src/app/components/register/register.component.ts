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
  user:any = null;

  register(){
    var newUser: User = {
      name: this.name,
      username: this.username,
      password:this.password,
      email: this.email,
      dateOfBirth: '',
      notifications: false,
      createdAt:''
    }
    console.log(newUser);
    
    //finish this
    this.authenticationService.register(newUser).subscribe({
      next: () => {
        // Agora que o login foi concluído, você pode buscar o usuário do Local Storage
        this.userService.setUser(JSON.parse(localStorage.getItem('user') || '{}'));
        this.user = this.userService.getUser();
  
        // Verifica se o usuário foi encontrado e navega ou exibe uma mensagem de erro
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
