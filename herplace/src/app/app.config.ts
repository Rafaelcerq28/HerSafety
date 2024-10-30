import { ApplicationConfig, provideZoneChangeDetection } from '@angular/core';
import { provideRouter, withInMemoryScrolling } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';

import { provideHttpClient, withFetch } from '@angular/common/http';

export const appConfig: ApplicationConfig = {
  //Using withInMemoryScrolling to return to the top of the page
  providers: [provideZoneChangeDetection({ eventCoalescing: true }), provideRouter(routes,withInMemoryScrolling({
    scrollPositionRestoration: 'enabled',
  })), provideClientHydration(),provideHttpClient(withFetch())]
};
