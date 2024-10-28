import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PlaceComponent } from './components/place/place.component';
import { SearchComponent } from './components/search/search.component';

export const routes: Routes = [
    {path: '',component: HomeComponent},
    {path: 'place', component: PlaceComponent},
    {path: 'search', component: SearchComponent}
];
