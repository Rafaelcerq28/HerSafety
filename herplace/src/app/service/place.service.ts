import { Injectable } from '@angular/core';
import { Place } from '../Place';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlaceService {

  constructor(private httpClient: HttpClient) { }

  private apiUrl : string = "http://localhost:8080/place";

  getPlace(name:string):Observable<Place>{
    return this.httpClient.get<Place>(`${this.apiUrl}?name=${name}`);
  }

}
