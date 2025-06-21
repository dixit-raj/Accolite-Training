import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { Product } from '../models/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private products: Product[] = [
    {
      productId: 1,
      title: 'Wireless Bluetooth Headphones',
      quantity: 1,
      stock: 15,
      image: 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=300&h=200&fit=crop',
      price: 99.99
    },
    {
      productId: 2,
      title: 'Smart Fitness Watch',
      quantity: 1,
      stock: 0,
      image: 'https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=300&h=200&fit=crop',
      price: 299.99
    },
    {
      productId: 3,
      title: 'MacBook Pro Laptop',
      quantity: 1,
      stock: 8,
      image: 'https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=300&h=200&fit=crop',
      price: 1299.99
    },
    {
      productId: 4,
      title: 'iPhone 15 Pro',
      quantity: 1,
      stock: 12,
      image: 'https://images.unsplash.com/photo-1592750475338-74b7b21085ab?w=300&h=200&fit=crop',
      price: 999.99
    },
    {
      productId: 5,
      title: 'Gaming Console PS5',
      quantity: 1,
      stock: 0,
      image: 'https://images.unsplash.com/photo-1606813907291-d86efa9b94db?w=300&h=200&fit=crop',
      price: 499.99
    },
    {
      productId: 6,
      title: 'iPad Pro Tablet',
      quantity: 1,
      stock: 20,
      image: 'https://images.unsplash.com/photo-1544244015-0df4b3ffc6b0?w=300&h=200&fit=crop',
      price: 799.99
    },
    {
      productId: 7,
      title: 'Canon DSLR Camera',
      quantity: 1,
      stock: 5,
      image: 'https://images.unsplash.com/photo-1502920917128-1aa500764cbd?w=300&h=200&fit=crop',
      price: 899.99
    },
    {
      productId: 8,
      title: 'Wireless Keyboard & Mouse',
      quantity: 1,
      stock: 25,
      image: 'https://images.unsplash.com/photo-1587829741301-dc798b83add3?w=300&h=200&fit=crop',
      price: 129.99
    }
  ];

  getProducts(): Observable<Product[]> {
    // Simulate API call with delay
    return of(this.products).pipe(delay(500));
  }

  getProductById(id: number): Observable<Product | undefined> {
    const product = this.products.find(p => p.productId === id);
    return of(product).pipe(delay(300));
  }

  updateProductStock(productId: number, newStock: number): Observable<boolean> {
    const product = this.products.find(p => p.productId === productId);
    if (product) {
      product.stock = newStock;
      return of(true).pipe(delay(200));
    }
    return of(false);
  }
}