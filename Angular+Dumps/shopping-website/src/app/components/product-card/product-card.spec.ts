import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { ProductCardComponent } from './product-card';
import { AppState } from '../../store/app.state';
import { Product } from '../../models/product.model';

describe('ProductCardComponent', () => {
  let component: ProductCardComponent;
  let fixture: ComponentFixture<ProductCardComponent>;
  let store: MockStore<AppState>;

  const initialState: AppState = {
    products: {
      products: [],
      loading: false,
      error: null
    },
    cart: {
      items: [],
      total: 0
    }
  };

  const mockProduct: Product = {
    productId: 1,
    title: 'Test Product',
    quantity: 1,
    stock: 5,
    image: 'test-image.jpg',
    price: 99.99
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductCardComponent],
      providers: [
        provideMockStore({ initialState })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(ProductCardComponent);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    component.product = mockProduct;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display product information', () => {
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.card-title').textContent).toContain('Test Product');
    expect(compiled.querySelector('.text-primary').textContent).toContain('$99.99');
  });

  it('should show Add to Cart button when product is in stock', () => {
    expect(component.isOutOfStock).toBeFalsy();
    const addToCartBtn = fixture.nativeElement.querySelector('.btn-primary');
    expect(addToCartBtn.textContent).toContain('Add to Cart');
  });

  it('should show out of stock message when stock is 0', () => {
    component.product = { ...mockProduct, stock: 0 };
    fixture.detectChanges();
    expect(component.isOutOfStock).toBeTruthy();
  });
});