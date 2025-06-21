import { Product, CartItem } from '../models/product.model';

export interface AppState {
  products: ProductState;
  cart: CartState;
}

export interface ProductState {
  products: Product[];
  loading: boolean;
  error: string | null;
}

export interface CartState {
  items: CartItem[];
  total: number;
}