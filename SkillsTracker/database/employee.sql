begin transaction;

drop table if exists employee;

create table employee(
id varchar(40) not null,
firstName varchar (40) not null,
lastName varchar (40) not null,
contactEmail varchar (40),
companyEmail varchar (40),
birthDate date,
hiredDate date,
role varchar (40),
businessUnit varchar (40),
assignedTo varchar (40),
constraint PK_employee primary key(id)
);

insert into employee(id, firstName, lastName)
values('123e4567-e89b-12d3-a456-426655440000', 'John', 'Smith');

commit transaction;