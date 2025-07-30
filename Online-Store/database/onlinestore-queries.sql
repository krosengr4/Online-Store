DROP DATABASE IF EXISTS online_store;
 
CREATE DATABASE online_store;
use online_store;
 
CREATE TABLE products(
	product_id INT NOT NULL AUTO_INCREMENT,
    department_id INT NOT NULL,
    SKU varchar(30) NOT NULL,
    name VARCHAR(50) NOT NULL,
    price DOUBLE NOT NULL,
    PRIMARY KEY(product_id)
    );
 
CREATE TABLE departments(
	department_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    PRIMARY KEY(department_id)
    );
    
CREATE TABLE cart(
	product_id int NOT NULL,
    quantity int NOT NULL,
    price double NOT NULL
    );
    
CREATE TABLE orders(
	order_id INT NOT NULL AUTO_INCREMENT,
    date DATETIME NOT NULL,
    name VARCHAR(74) NOT NULL,
    address VARCHAR(100) NOT NULL,
    city VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    PRIMARY KEY(order_id)
    );
    
CREATE TABLE order_line_items(
	line_item_id INT NOT NULL AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    sales_price DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY(line_item_id),
    FOREIGN KEY(order_id) REFERENCES orders(order_id),
    FOREIGN KEY(product_id) REFERENCES products(product_id)
    );
    
    
INSERT INTO departments (name)
VALUES ('audio-video'), ('computers'), ('games'), ('electronics'), ('toiletries');
 
insert into products (SKU, name, price, department_id)
VALUES ('AV1051', 'JBL Bluetooth Speaker', 89.95, 1),
('AV1312', 'Mini 1000 Lumens Projector', 149.95, 1),
('AV1412', 'XLR Podcast Cardiod Mic', 44.99, 1),
('CP2012', 'Desktop PC Computer Intel Core i5', 139.00, 2),
('CP2123', 'Wired Backlit Keyboard', 21.99, 2),
('CP2154', 'RGB Wireless Gaming Mouse', 67.49, 2),
('GM1032', 'Telestrations Board Game', 17.99, 3),
('GM1075', 'Battleship Board Game', 12.99, 3),
('GM1148', 'Retro Handheld Arcade', 24.45, 3),
('PW1255', 'USB C to A Cable', 13.95, 4),
('PW1341', 'Solar Powered Battery Charger', 19.99, 4),
('PW1431', 'Wireless Charger iPhone', 12.99, 4);