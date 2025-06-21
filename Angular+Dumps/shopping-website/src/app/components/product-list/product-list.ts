import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Product } from '../../models/product.model';
import { AppState } from '../../store/app.state';
import { selectAllProducts, selectProductsLoading, selectProductsError } from '../../store/products/product.selectors';
import { loadProducts } from '../../store/products/product.actions';
import { ProductCardComponent } from '../product-card/product-card';

@Component({
  selector: 'app-product-list',
  standalone: true,
  imports: [CommonModule,  ProductCardComponent],
  templateUrl: './product-list.html',
  styleUrls: ['./product-list.scss']
})
export class ProductListComponent implements OnInit {
  products$: Observable<Product[]>;
  loading$: Observable<boolean>;
  error$: Observable<string | null>;

  constructor(private store: Store<AppState>) {
    this.products$ = this.store.select(selectAllProducts);
    this.loading$ = this.store.select(selectProductsLoading);
    this.error$ = this.store.select(selectProductsError);
  }

  ngOnInit(): void {
    // Uncomment the line below if you want to load products via effects
    // this.store.dispatch(loadProducts());
  }

  onRetry(): void {
    this.store.dispatch(loadProducts());
  }

  trackByProductId(index: number, product: Product): number {
  return product.productId;
  }

}