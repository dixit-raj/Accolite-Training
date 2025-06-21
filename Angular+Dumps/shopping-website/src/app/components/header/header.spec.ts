import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { HeaderComponent } from './header';
import { AppState } from '../../store/app.state';

describe('HeaderComponent', () => {
  let component: HeaderComponent;
  let fixture: ComponentFixture<HeaderComponent>;
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
      imports: [HeaderComponent],
      providers: [
        provideMockStore({ initialState })
      ]
    }).compileComponents();

    fixture = TestBed.createComponent(HeaderComponent);
    component = fixture.componentInstance;
    store = TestBed.inject(MockStore);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display cart items count', () => {
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.badge')).toBeTruthy();
  });

  it('should toggle cart visibility', () => {
    expect(component.showCart).toBeFalsy();
    component.toggleCart();
    expect(component.showCart).toBeTruthy();
  });
});