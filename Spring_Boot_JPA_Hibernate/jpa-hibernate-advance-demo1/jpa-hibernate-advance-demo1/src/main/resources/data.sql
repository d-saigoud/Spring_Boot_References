insert into course_details (id, name, last_updated_date, created_date)
values (10001, 'Course 1', sysdate(), sysdate());

insert into course_details (id, name, last_updated_date, created_date)
values (10002, 'Course 2', sysdate(), sysdate());

insert into course_details (id, name, last_updated_date, created_date)
values (10003, 'Course 3', sysdate(), sysdate());




insert into passport (id, number)
values (40001, 'E123456');

insert into passport (id, number)
values (40002, 'N123456');

insert into passport (id, number)
values (40003, 'L123456');




insert into student (id, name, passport_id)
values (20001, 'Sai', 40001);

insert into student (id, name, passport_id)
values (20002, 'Thomas', 40002);

insert into student (id, name, passport_id)
values (20003, 'John', 40003);




insert into review (id, rating, description)
values (50001, '5', 'Great Course');

insert into review (id, rating, description)
values (50002, '4', 'Wonderful Course');

insert into review (id, rating, description)
values (50003, '5', 'Awesome Course');