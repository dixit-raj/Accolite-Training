import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { HeaderComponent } from './components/header/header';
import { ProductListComponent } from './components/product-list/product-list';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    HeaderComponent,
    ProductListComponent
  ],
  template: `
    <div class="app-container">
      <app-header></app-header>
      <main class="main-content">
        <app-product-list></app-product-list>
      </main>
    </div>
  `,
  styleUrls: ['./app.scss']
})
export class AppComponent implements OnInit {
  title = 'ShopEasy';

  constructor(private store: Store) {}

  ngOnInit() {
    // Component initialization logic here
    console.log('App component initialized');
  }
}
