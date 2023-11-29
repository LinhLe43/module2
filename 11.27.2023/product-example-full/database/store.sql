create database product;
use product;
create table product
(
    id         int         not null primary key auto_increment,
    name       varchar(60) not null,
    price      double      not null,
    quantity   int         not null default 0,
    idCategory int,
    foreign key (idCategory) references category (id)
);

create table category
(
    id   int         not null primary key auto_increment,
    name varchar(60) not null
);

-- Find All product
select p.*, c.name as categoryName
from product p
         join category c on c.id = p.idCategory;

-- Add product
insert into product(name, price, quantity, idCategory)
values (?, ?, ?, ?);

-- Get product by id
select p.*, c.name as categoryName
from product p
         join category c on c.id = p.idCategory
where p.id = ?;

-- Delete product
delete
from product p
where p.id = ?;

-- Update product
update product
set name       = ?,
    price      = ?,
    quantity   = ?,
    idCategory = ?
where id = ?;

-- Find All Category
select *
from category;