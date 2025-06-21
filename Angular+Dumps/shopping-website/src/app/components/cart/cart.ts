import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { CartItem } from '../../models/product.model';
import { AppState } from '../../store/app.state';
import { selectCartItems, selectCartTotal } from '../../store/cart/cart.selectors';
import { removeFromCart, updateCartItemQuantity, clearCart } from '../../store/cart/cart.actions';

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.html',
  styleUrls: ['./cart.scss']
})
export class CartComponent implements OnInit {
  @Output() close = new EventEmitter<void>();
  
  cartItems$: Observable<CartItem[]>;
  cartTotal$: Observable<number>;

  constructor(private store: Store<AppState>) {
    this.cartItems$ = this.store.select(selectCartItems);
    this.cartTotal$ = this.store.select(selectCartTotal);
  }

  ngOnInit(): void {}

  onClose(): void {
    this.close.emit();
  }

  onRemoveItem(productId: number): void {
    this.store.dispatch(removeFromCart({ productId }));
  }

  onUpdateQuantity(productId: number, quantity: number): void {
    if (quantity > 0) {
      this.store.dispatch(updateCartItemQuantity({ productId, quantity }));
    } else {
      this.store.dispatch(removeFromCart({ productId }));
    }
  }

  onClearCart(): void {
    if (confirm('Are you sure you want to clear the cart?')) {
      this.store.dispatch(clearCart());
    }
  }

  onCheckout(): void {
    alert('🎉 Checkout functionality coming soon!');
  }
}
