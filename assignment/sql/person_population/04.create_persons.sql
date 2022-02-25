/**
 * write a function that returns random birth date
 * write a function that returns to get random first name and gender
 * 
 * 
*/

create table person (
	cpr VARCHAR(10) primary key ,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	gender CHAR(1),
	birthday DATE
);

/*
 * takes number of days from current date to 1900-01-01 
 * and picks a random number of days 
 * to return difference between current date and those days as a date
 */
create or replace function randomDate()
	returns date as 
	$$ 		
		select current_date - (select floor(random() * (select current_date-'1900-01-01')+1)::int);		
	$$
	language 'sql'
	volatile;


/**
 * function creates a cpr number according to the birth date and gender
 * 
 */
create or replace function cpr(birth date, male boolean  )
	returns char(9) as
	$$ 
		select concat(
			(select to_char(birth, 'DDMMYY')),
			(select (floor(random() * 10))),
			(select (floor(random() * 90)+10)::varchar),
			(select(floor(random() * 5))*2 + male::int)
		);
		
	$$ 
	language 'sql'
	volatile;

/**
 * returns a table like person with one row:
 * creates a person with random birthdate, random firstname and accurate gender 
 * uses that person to create cpr
 * and takes random lastname
 * 
 */
create or replace function create_person()
	returns table (
			cpr char(10) ,
			first_name varchar, 
			last_name varchar,
			gender char(1),			 
			birthday date)
	language plpgsql
	as $$ 
	begin
		return query
				with base as 
	(
		select randomDate() as birth, fn.first_name, fn.gender from first_name fn order by random() limit 1
	)
	
	select 
		cpr(
			base.birth,				
				(
				select case 
					when base.gender='M'
						then 1
						else 0
					end 
				 from base
				)::boolean 
			) as cpr, 	
		base.first_name as first_name, 
		(select ln2.last_name  from last_name ln2 order by random() limit 1) as last_name,
		base.gender as gender,  
		base.birth as birthday  
	from base; 
	end	
	$$;

/**
 * For given q inserts random person to person table
 * If cpr already exists reduces q with number of inserted persons and recurses
 *  -- can caouse stack depth limit exceeded if runned for q > 500 000
 */
create or replace function populate_person(q int)
	returns text 
	language plpgsql	
	as 	
		$$
	declare 
	counter int :=0;
	begin 		
		raise notice 'start with q: %', q ;		
		while counter < q loop 
			begin					
				insert into person select * from create_person ();			
				exception
					when unique_violation then 	 			
					raise notice 'Duplicate at counter: %', counter ;
					--counter := counter-1; 
					return populate_person(q-counter);
			end;
			counter := counter+1;		
		end loop;
		return true;							
	end
		$$
	;


select populate_person(50000);
select count(*) from person ;
--delete from person where 1=1;
-- cpr creation:
-- last digit L for a man is random int from between 0-4 as r where L=r*2+1
-- last digit L for a woman is random int from between 0-4 as r where L=r*2
-- digit at position 8-9 is a random number from (10,99)
-- digit at position 7 is a random number from (0,9)