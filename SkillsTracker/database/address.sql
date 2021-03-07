begin transaction;

drop table if exists address;

create table address(
id varchar(40) not null,
street varchar(40) not null,
suite varchar(40),
city varchar(40) not null,
region varchar(40) not null,
postal varchar(40) not null,
country varchar(40) not null,
constraint fk_address_id foreign key(id) references employee(id)
);

insert into address(id, street, suite, city, region, postal, country)
values ('123e4567-e89b-12d3-a456-426655440000', '123 Main St.', ' Apt. 456', 'Detroit', 'MI', '48201', 'US');


commit transaction;