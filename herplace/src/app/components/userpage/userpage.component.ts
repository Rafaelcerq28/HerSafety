import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { UserService } from '../../service/user.service';

@Component({
  selector: 'app-userpage',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,RouterLinkActive,FormsModule],
  templateUrl: './userpage.component.html',
  styleUrl: './userpage.component.css'
})
export class UserpageComponent {
  selected = '';
  user?:any = null;

  constructor(private userService: UserService){
    // Verifica se a página já foi recarregada nesta sessão
    const hasReloaded = sessionStorage.getItem('hasReloaded');

    if (!hasReloaded) {
      // Armazena o estado de recarregamento no sessionStorage para evitar loops
      sessionStorage.setItem('hasReloaded', 'true');
      
      // Recarrega a página apenas uma vez
      this.reload();
    } else {
      this.user = this.userService.getUser();
    }
  }

  thechosen(){
    console.log("selected " + this.selected)
  }

  reload():void{
    location.reload();
  }
}
