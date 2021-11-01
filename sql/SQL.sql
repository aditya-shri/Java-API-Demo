Create table Items (name varchar(50) primary key, description varchar(75), price int);
Insert into Items values('banana', 'fruit', 5);

Create sequence Orders_seq;
Create table Orders (id int primary key default nextval ('Orders_seq'), userid int, item varchar(50), description varchar(100), quantity int);

Create sequence Users_seq;
Create table Users (id int primary key default nextval ('Users_seq'),name varchar(50),mobile int, email varchar(50), address varchar(150));
