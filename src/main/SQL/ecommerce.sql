#Creacion de DB con MySQL
create database ecommerce;

#Uso de DB
use ecommerce;

#Creacion de tablas
CREATE TABLE clients(
idClients int primary key auto_increment,
name varchar(75) not null,
lastname varchar(75) not null,
docnumber varchar(11) not null unique);

CREATE TABLE invoices(
idInvoices int primary key auto_increment,
client_id int not null,
created_at datetime not null,
total double unsigned not null,
constraint fk_id_clients_tbl foreign key(client_id) references clients(idClients));

CREATE TABLE products(
id_products int primary key auto_increment,
description varchar(75) not null unique,
code varchar(50) not null unique,
stock int unsigned not null,
price double unsigned not null);

CREATE TABLE invoice_details(
invoice_id int not null,
invoice_detail_id int primary key auto_increment, 
amount int unsigned not null,
product_id int not null,
price double unsigned not null,
constraint fk_id_invoice_tbl foreign key(invoice_id) references invoice(idInvoices),
constraint fk_id_products_tbl foreign key(product_id) references products(idProducts));

show tables;
describe clients;

#Insercion de datos
INSERT INTO clients (name, lastname, docnumber) VALUES 
("Ruben", "Gonzalez", "11111111111"),
("Livier", "Davalos", "11111111112"),
("Cristiano", "Ronaldo", "11111111113");
SELECT * FROM clients;

INSERT INTO invoices (client_id, created_at, total) VALUES 
(1, "2023-03-14", 21),
(2, "2023-03-14", 22),
(3, "2023-03-14", 23);
SELECT * FROM invoices;


INSERT INTO products (description, code, stock, price) VALUES 
("Escoba", "001", 10, 10.5),
("Trapeador", "002", 11, 11.5),
("Recogedor", "003", 12, 12.5);
SELECT * FROM products;


INSERT INTO invoice_details (invoice_id, amount, product_id, price) VALUES
(1, 5, 1, 52.5), 
(2, 5, 2, 57.5),
(3, 5, 3, 62.5);
SELECT * FROM invoice_details;

DROP database ecommerce;