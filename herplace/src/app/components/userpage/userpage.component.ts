import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { UserService } from '../../service/user.service';
import { userInfo } from 'os';

@Component({
  selector: 'app-userpage',
  standalone: true,
  imports: [CommonModule,RouterOutlet,RouterLink,RouterLinkActive,FormsModule],
  templateUrl: './userpage.component.html',
  styleUrl: './userpage.component.css'
})
export class UserpageComponent {
  question1 = '';
  question2 = '';
  question3 = '';
  question4 = '';
  question5 = '';
  edit:boolean = false;


  user?:any = null;
  securityInfo?:any;

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
      this.getSecurityInfo();
    }

    console.log("iniciado " + this.question1)
  }

  //Edit security info
  editSecurityInfo(){
    this.userService.editSecurityInfo(this.user.username,this.question1,this.question2,this.question3,this.question4,this.question5).subscribe((securityInfo) => {
      this.securityInfo = securityInfo;
    })
  }

  //Get securityInfo
  getSecurityInfo(){
    this.userService.getSecurityInfo(this.user.username).subscribe((securityInfo) => {
      this.securityInfo = securityInfo;
      
      if(securityInfo != null){
        this.question1 = securityInfo.question1;
      }else{
        this.edit = true
      }
      console.log(this.securityInfo)
    })
  }

//Event to get the selected item 
  onSelectChange1(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question1  = target.value;
  }

  onSelectChange2(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question2  = target.value;
  }
  onSelectChange3(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question3  = target.value;
  }
  onSelectChange4(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question4  = target.value;
  }
  onSelectChange5(event:Event){
    const target = event.target as HTMLSelectElement;
    this.question5  = target.value;
    console.log(this.user);
  }

  reload():void{
    location.reload();
  }

  showSelection(){
    this.edit = !this.edit;
  }
}
