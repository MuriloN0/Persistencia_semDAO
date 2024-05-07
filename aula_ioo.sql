create database aula_ioo;

use aula_ioo;

create table produto (

`id` serial,
`descricao` character varying(50),
`preco` double precision
);

Select * from produto;
insert into produto (id, descricao, preco)
values (3,"teclado com fio", 40);


