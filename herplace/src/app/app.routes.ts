import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PlaceComponent } from './components/place/place.component';

export const routes: Routes = [
    {path: '',component: HomeComponent},
    {path: 'place', component: PlaceComponent}
];
