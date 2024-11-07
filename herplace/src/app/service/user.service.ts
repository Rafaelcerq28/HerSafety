import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  private userKey = 'user';

  setUser(user: any): void {
    try{
      localStorage.setItem(this.userKey, JSON.stringify(user));
    }catch (error){
      console.log("error when acessing the local storage",error);
    }
  }

  getUser(): any {
    try{
      const user = localStorage.getItem(this.userKey);
      return user ? JSON.parse(user) : null;
    }catch (error){
      console.log("error when acessing the local storage",error);
      return null;
    }
  }

  clearUser(): void {
    localStorage.removeItem(this.userKey);
  }
  
}
