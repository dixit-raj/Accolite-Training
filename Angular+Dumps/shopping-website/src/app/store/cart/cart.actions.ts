import { createAction, props } from '@ngrx/store';
import { Product } from '../../models/product.model';

export const addToCart = createAction(
  '[Cart] Add To Cart',
  props<{ product: Product }>()
);
export const removeFromCart = createAction(
  '[Cart] Remove From Cart',
  props<{ productId: number }>()
);
export const updateCartItemQuantity = createAction(
  '[Cart] Update Cart Item Quantity',
  props<{ productId: number; quantity: number }>()
);
export const clearCart = createAction('[Cart] Clear Cart');