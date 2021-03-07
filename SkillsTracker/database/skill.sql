begin transaction;

drop table if exists skill;

create table skill(
id varchar (40) not null,
field varchar (40) not null,
field_type varchar (40) not null,
experience int not null,
summary text,
constraint FK_skill_id foreign key (id) references employee(id)
);

insert into skill (id, field, field_type, experience, summary)
values ('123e4567-e89b-12d3-a456-426655440000', 'Java', 'Software Development', 60, 'Worked with multi-threading and generics.');

commit transaction;