import { createReducer, on } from '@ngrx/store';
import { CartState } from '../app.state';
import * as CartActions from './cart.actions';
import { CartItem } from '../../models/product.model';

export const initialState: CartState = {
  items: [],
  total: 0
};

export const cartReducer = createReducer(
  initialState,
  on(CartActions.addToCart, (state, { product }) => {
    const existingItem = state.items.find(item => item.product.productId === product.productId);
    
    if (existingItem) {
      const updatedItems = state.items.map(item =>
        item.product.productId === product.productId
          ? { ...item, quantity: item.quantity + 1 }
          : item
      );
      return {
        ...state,
        items: updatedItems,
        total: calculateTotal(updatedItems)
      };
    } else {
      const newItems = [...state.items, { product, quantity: 1 }];
      return {
        ...state,
        items: newItems,
        total: calculateTotal(newItems)
      };
    }
  }),
  on(CartActions.removeFromCart, (state, { productId }) => {
    const updatedItems = state.items.filter(item => item.product.productId !== productId);
    return {
      ...state,
      items: updatedItems,
      total: calculateTotal(updatedItems)
    };
  }),
  on(CartActions.updateCartItemQuantity, (state, { productId, quantity }) => {
    const updatedItems = state.items.map(item =>
      item.product.productId === productId
        ? { ...item, quantity }
        : item
    );
    return {
      ...state,
      items: updatedItems,
      total: calculateTotal(updatedItems)
    };
  }),
  on(CartActions.clearCart, () => initialState)
);

function calculateTotal(items: CartItem[]): number {
  return items.reduce((total, item) => total + (item.product.price * item.quantity), 0);
}