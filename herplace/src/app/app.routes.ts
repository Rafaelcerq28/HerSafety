import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { PlaceComponent } from './components/place/place.component';
import { SearchComponent } from './components/search/search.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { UserpageComponent } from './components/userpage/userpage.component';
import { MakereportComponent } from './components/makereport/makereport.component';
import { RedirectComponent } from './components/redirect/redirect.component';
import { ModeratorComponent } from './components/moderator/moderator.component';

export const routes: Routes = [
    {path: '',component: HomeComponent},
    {path: 'place', component: PlaceComponent},
    {path: 'place/:name', component: PlaceComponent},
    {path: 'place/:id', component: PlaceComponent},
    {path: 'search', component: SearchComponent},
    {path: 'redirect', component: RedirectComponent},
    {path: 'login', component: LoginComponent},
    {path: 'register', component: RegisterComponent},
    {path: 'user', component: UserpageComponent},
    {path: 'user/:username', component: UserpageComponent},
    {path: 'report', component: MakereportComponent},
    {path: 'moderator', component: ModeratorComponent},
    { path: '**', redirectTo: '' },
];