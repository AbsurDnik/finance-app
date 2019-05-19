create sequence hibernate_sequence start 2 increment 1;

create table bank (
	id int4 not null, 
	relax_bank float8, 
	storage_bank float8, 
	total_costs_bank float8, 
	primary key (id)
);

create table consumption (
	id int4 not null, 
	category varchar(255), 
	creation_date_time timestamp, 
	my_consumption int4 not null, 
	sub_category varchar(255),
	primary key (id)
);
create table income (
	id int4 not null, 
	creation_date date, 
	my_income int4 not null,
	relax int4 not null, 
	storage int4 not null, 
	total_costs int4 not null, 
	primary key (id)
);