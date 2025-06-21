import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of } from 'rxjs';
import { map, mergeMap, catchError, tap } from 'rxjs/operators';
import { ProductService } from '../../services/product-service';
import { NotificationService } from '../../services/notification-service';
import * as ProductActions from './product.actions';

@Injectable()
export class ProductEffects {
  loadProducts$ = createEffect(() =>
    this.actions$.pipe(
      ofType(ProductActions.loadProducts),
      mergeMap(() =>
        this.productService.getProducts().pipe(
          map(products => ProductActions.loadProductsSuccess({ products })),
          catchError(error => of(ProductActions.loadProductsFailure({ 
            error: error.message 
          })))
        )
      )
    )
  );

  notifyWhenAvailable$ = createEffect(() =>
    this.actions$.pipe(
      ofType(ProductActions.notifyWhenAvailable),
      tap(({ productId }) => {
        this.notificationService.addNotification(
          `You'll be notified when Product #${productId} is back in stock!`,
          'success'
        );
      })
    ),
    { dispatch: false }
  );

  constructor(
    private actions$: Actions,
    private productService: ProductService,
    private notificationService: NotificationService
  ) {}
}