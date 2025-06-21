import { createReducer, on } from '@ngrx/store';
import { ProductState } from '../app.state';
import * as ProductActions from './product.actions';

export const initialState: ProductState = {
  products: [
    {
      productId: 1,
      title: 'Wireless Headphones',
      quantity: 1,
      stock: 5,
      image: 'https://via.placeholder.com/300x200?text=Headphones',
      price: 99.99
    },
    {
      productId: 2,
      title: 'Smart Watch',
      quantity: 1,
      stock: 0,
      image: 'https://via.placeholder.com/300x200?text=Smart+Watch',
      price: 199.99
    },
    {
      productId: 3,
      title: 'Laptop',
      quantity: 1,
      stock: 3,
      image: 'https://via.placeholder.com/300x200?text=Laptop',
      price: 899.99
    },
    {
      productId: 4,
      title: 'Smartphone',
      quantity: 1,
      stock: 8,
      image: 'https://via.placeholder.com/300x200?text=Smartphone',
      price: 599.99
    },
    {
      productId: 5,
      title: 'Gaming Console',
      quantity: 1,
      stock: 0,
      image: 'https://via.placeholder.com/300x200?text=Gaming+Console',
      price: 499.99
    },
    {
      productId: 6,
      title: 'Tablet',
      quantity: 1,
      stock: 7,
      image: 'https://via.placeholder.com/300x200?text=Tablet',
      price: 299.99
    }
  ],
  loading: false,
  error: null
};

export const productReducer = createReducer(
  initialState,
  on(ProductActions.loadProducts, (state) => ({
    ...state,
    loading: true
  })),
  on(ProductActions.loadProductsSuccess, (state, { products }) => ({
    ...state,
    loading: false,
    products
  })),
  on(ProductActions.loadProductsFailure, (state, { error }) => ({
    ...state,
    loading: false,
    error
  })),
  on(ProductActions.notifyWhenAvailable, (state, { productId }) => {
    console.log(`Notification set for product ${productId}`);
    return state;
  })
);