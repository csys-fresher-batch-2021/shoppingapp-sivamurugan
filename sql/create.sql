create database ShopApp;

create table userdetails(
	id serial primary key,
	name varchar(40) not null,
	age int,
	gender char(1),
	mobile_no bigint not null,
	email varchar(40) not null,
	username varchar(20) not null,
	password varchar(20) not null,
	role char(1),
	unique(mobile_no, email, username)
);

create table veg_details(
	id serial primary key,
	name varchar(20) not null,
	price int not null,
	quantity int not null,
	unique(name)
);

create table order_items(
	order_id bigint,
	veg_id serial not null,
	veg_name varchar(30) not null,
	veg_price numeric not null,
	veg_quantity int not null,
	each_veg_price numeric not null
);

create table order_details(
	order_id serial primary key,
	username varchar(30) not null,
	total_bill numeric not null,
	status varchar(30) not null,
	active boolean not null,
	created_date timestamp not null,
	delivery_date timestamp not null,
	payment_method varchar(30) not null,
	address varchar(200) not null,
	cancel_reason varchar(200)
);

create table discount_coupons(
	id serial primary key,
	username varchar(30) not null,
	coupon varchar(15) not null,
	amount int not null,
	status varchar(15) default 'AVAILABLE',
	expiry_date timestamp not null
)
