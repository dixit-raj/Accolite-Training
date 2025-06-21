import { bootstrapApplication } from '@angular/platform-browser';
import { provideStore } from '@ngrx/store';
import { provideEffects } from '@ngrx/effects';
import { provideStoreDevtools } from '@ngrx/store-devtools';
import { AppComponent } from './app/app.module';
import { productReducer } from './app/store/products/product.reducer';
import { cartReducer } from './app/store/cart/cart.reducer';
import { ProductEffects } from './app/store/products/product.effects';
import { isDevMode } from '@angular/core';

bootstrapApplication(AppComponent, {
  providers: [
    provideStore({
      products: productReducer,
      cart: cartReducer
    }),
    provideEffects([ProductEffects]),
    provideStoreDevtools({
      maxAge: 25,
      logOnly: !isDevMode(),
      autoPause: true,
      trace: false,
      traceLimit: 75,
      connectInZone: true
    })
  ]
}).catch(err => console.error(err));