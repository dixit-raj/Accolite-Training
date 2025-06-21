import { TestBed } from '@angular/core/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { AppComponent } from './app.module';
import { AppState } from './store/app.state';

describe('AppComponent', () => {
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

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppComponent],
      providers: [
        provideMockStore({ initialState })
      ]
    }).compileComponents();
    
    store = TestBed.inject(MockStore);
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('app-header')).toBeTruthy();
    expect(compiled.querySelector('app-product-list')).toBeTruthy();
  });
});