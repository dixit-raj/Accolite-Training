export interface Product {
  productId: number;
  title: string;
  quantity: number;
  stock: number;
  image: string;
  price: number;
}

export interface CartItem {
  product: Product;
  quantity: number;
}