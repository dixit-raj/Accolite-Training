import { bootstrapApplication } from '@angular/platform-browser';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { isDevMode } from '@angular/core';
import { AppComponent } from './app/app.module';
import { productReducer } from './app/store/products/product.reducer';
import { cartReducer } from './app/store/cart/cart.reducer';

bootstrapApplication(AppComponent, {
  providers: [
    // NgRx Store Configuration
    provideStore({
      products: productReducer,
      cart: cartReducer
    }),
    provideEffects([
      // Add your effects here if needed
    ]),
    provideStoreDevtools({
      maxAge: 25,
      logOnly: !isDevMode()
    })
  ]
}).catch(err => console.error(err));
