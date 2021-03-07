begin transaction;

drop table if exists skill;

create table skill(
id varchar (40) not null,
skill_id varchar (40) not null,
skill_field_id varchar (40) not null,
field varchar (40) not null,
field_type varchar (40) not null,
experience int not null,
summary text,
constraint PK_skill_id primary key (skill_id),
constraint FK_id foreign key (id) references employee(id)
);

insert into skill (id, skill_id, skill_field_id, field, field_type, experience, summary)
values ('123e4567-e89b-12d3-a456-426655440000', '418ik-13241234-99', '1098123k=13241234-lmnop', 'Java', 'Software Development', 60, 'Worked with multi-threading and generics.');

commit transaction;