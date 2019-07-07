﻿--create table person(personid integer primary key,fname varchar,mname varchar,lname varchar,age integer,sex char,email varchar,phoneno varchar) 
--create table libuser(userpersonid integer primary key, uname varchar unique,password varchar,personid integer references person(personid),isactive boolean, level varchar(6))
--create table books(titleid integer primary key,btitle varchar,author varchar,description varchar,image varchar,numberofcopies integer) 
--create table book (bookid integer primary key,titleid integer references books(titleid),isresereved boolean,ischeckedout boolean,isactive boolean)
--create table cart(cartid integer primary key,personid integer references person(personid),ischeckedout boolean,isactive boolean)
--create table cartitem(cartitemid integer primary key,cartid integer references cart(cartid),bookid integer references book(bookid),isactive boolean)
--create table checkout(checkoutid integer primary key,cartid integer references cart(cartid),personid integer references person(personid),isactive boolean)