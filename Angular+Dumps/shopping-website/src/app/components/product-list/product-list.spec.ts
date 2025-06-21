import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { ProductListComponent } from './product-list';
import { AppState } from '../../store/app.state';

describe('ProductListComponent', () => {
  let component: ProductListComponent;
  let fixture: ComponentFixture<ProductListComponent>;
  let store: MockStore<AppState>;

  const initialState: AppState = {
    products: {
      products: [
        {
          productId: 1,
          title: 'Test Product',
          quantity: 1,
          stock: 5,
          image: 'test.jpg',
          price: 99.99
        }
      ],
      loading: false,
      error: null
    },
    cart: {
      items: [],
      total: 0
    }
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProductListComponent],
      providers: [
        provideMockStore({ initialState })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(ProductListComponent);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display products', () => {
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('app-product-card')).toBeTruthy();
  });
});