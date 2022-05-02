--V1__init.sql
drop table posts if exists;
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 1 increment by 1;
create table posts (id bigint not null, title varchar(255), description varchar(255), context varchar(255), createdAt date, updatedAt date, primary key (id));