import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Product } from '../../models/product.model';
import { AppState } from '../../store/app.state';
import { addToCart } from '../../store/cart/cart.actions';
import { notifyWhenAvailable } from '../../store/products/product.actions';

@Component({
  selector: 'app-product-card',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './product-card.html',
  styleUrls: ['./product-card.scss']
})
export class ProductCardComponent {
  @Input() product!: Product;

  constructor(private store: Store<AppState>) {}

  onAddToCart(): void {
    if (this.product.stock > 0) {
      this.store.dispatch(addToCart({ product: this.product }));
    }
  }

  onNotifyWhenAvailable(): void {
    this.store.dispatch(notifyWhenAvailable({ productId: this.product.productId }));
    alert('✅ You will be notified when this product is back in stock!');
  }

  get isOutOfStock(): boolean {
    return this.product.stock === 0;
  }

  get stockStatus(): string {
    if (this.product.stock === 0) return 'Out of Stock';
    if (this.product.stock < 5) return 'Low Stock';
    return 'In Stock';
  }

  get stockClass(): string {
    if (this.product.stock === 0) return 'text-danger';
    if (this.product.stock < 5) return 'text-warning';
    return 'text-success';
  }
}