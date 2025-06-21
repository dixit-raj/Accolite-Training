import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { AppState } from '../../store/app.state';
import { selectCartItemsCount } from '../../store/cart/cart.selectors';
import { CartComponent } from '../cart/cart';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule, CartComponent],
  templateUrl: './header.html',
  styleUrls: ['./header.scss']
})
export class HeaderComponent implements OnInit {
  cartItemsCount$: Observable<number>;
  showCart = false;

  constructor(private store: Store<AppState>) {
    this.cartItemsCount$ = this.store.select(selectCartItemsCount);
  }

  ngOnInit(): void {}

  toggleCart(): void {
    this.showCart = !this.showCart;
  }
}