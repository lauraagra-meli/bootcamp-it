-- cria um novo banco de dados
create database bd_meli01;

-- coloca o BD bd_meli01 como o banco deafult
use bd_meli01;

-- criar tabela
create table user (
	id integer,
    name varchar(100)
);

-- inserir registro na tabela
insert into user values (1, "Laura");
insert into user values (2, "Fabiana");

-- consultar tabela
select * from user;

-- criando indice
alter table user
add constraint primary key(id);

alter table user
add email varchar(50);

-- alterando registros da tabela
update user set email = 'fabi@email.com'
where id = 2;

-- alterando estrutura da tabela
alter table user
add constraint unique (email);

insert into tb_user values(null, 'laura@gmail.com', 'Laura'); -- gera em ordem alfabetica, e nao como criamos