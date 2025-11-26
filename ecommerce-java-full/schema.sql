CREATE DATABASE IF NOT EXISTS onlineshop;
USE onlineshop;

CREATE TABLE users (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100),
  email VARCHAR(150) UNIQUE,
  password_hash VARCHAR(255),
  role VARCHAR(20),
  created_at DATETIME
);

CREATE TABLE categories (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  description TEXT
);

CREATE TABLE products (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  description TEXT,
  price DECIMAL(10,2),
  stock_qty INT,
  image_url VARCHAR(500),
  category_id BIGINT,
  FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE carts (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT UNIQUE,
  created_at DATETIME,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cart_items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  cart_id BIGINT,
  product_id BIGINT,
  qty INT,
  unit_price DECIMAL(10,2),
  FOREIGN KEY (cart_id) REFERENCES carts(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);

CREATE TABLE orders (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  user_id BIGINT,
  total_amount DECIMAL(10,2),
  status VARCHAR(20),
  created_at DATETIME,
  shipping_address TEXT,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE order_items (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  order_id BIGINT,
  product_id BIGINT,
  qty INT,
  unit_price DECIMAL(10,2),
  FOREIGN KEY (order_id) REFERENCES orders(id),
  FOREIGN KEY (product_id) REFERENCES products(id)
);
