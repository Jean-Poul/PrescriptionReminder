/*
 * unique first name cration:
 * 1. Run script first_name_tmp.sql to use firstnames with corresponding gender M or F creted with generator
 * 2. delete duplicates by grouping names and saving them in a new table
 * 3. drop tmp table
 * 4. Run script last_name_tmp.sql to use firstnames with corresponding gender M or F creted with generator
 * 5. delete duplicates by grouping names and saving them in a new table
 * 6. drop tmp table
 */
create table first_name (
	first_name VARCHAR(50),
	gender CHAR(1)
);
with base as
	(
	select first_name
	from first_name_tmp
	where gender = 'M'			 
	group by first_name
	)
	insert into first_name (select first_name from base) ;
update first_name set gender = 'M' where 1=1  ;

with base as
	(
	select first_name
	from first_name_tmp
	where gender = 'F'			 
	group by first_name
	)
	insert into first_name (select first_name from base) ;
update first_name set gender = 'F' where  gender is null;

drop table first_name_tmp;

create table last_name (
	last_name VARCHAR(50)
);

with base as 
	(
	select last_name 
	from last_name_tmp lnt 
	group by last_name
	)
	insert into last_name (select last_name from base);

drop table last_name_tmp ;
	