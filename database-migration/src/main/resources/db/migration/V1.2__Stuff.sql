create table stuff
(
 id  INTEGER primary key not null,
 display_name  VARCHAR(255),
 created_date  TIMESTAMP
);
insert into stuff(id, display_name, created_date) values(1, 'item 1', now());
insert into stuff(id, display_name, created_date) values(2, 'item 2', now());
insert into stuff(id, display_name, created_date) values(3, 'item 3', now());