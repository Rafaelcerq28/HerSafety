import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PlaceComponent } from './components/place/place.component';
import { SearchComponent } from './components/search/search.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserpageComponent } from './components/userpage/userpage.component';

export const routes: Routes = [
    {path: '',component: HomeComponent},
    {path: 'place', component: PlaceComponent},
    {path: 'place/:name', component: PlaceComponent},
    {path: 'search', component: SearchComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'user/:username', component: UserpageComponent}
    
];
