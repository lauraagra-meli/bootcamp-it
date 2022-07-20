select * 
from movies;


select first_name, last_name, rating 
from actors;

select title as título 
from series as séries;

select first_name, last_name, rating 
from actors
where rating > 7.5;

select title, rating, awards
from movies as filmes
where rating > 7.5 and awards > 2;

select title
from movies
limit 3;

SELECT title
FROM movies
ORDER BY rating DESC
LIMIT 5;

select first_name, last_name
from actors
limit 10;

select title
from movies
where title like '%toy story%';

select title, release_date
from movies
-- where year(release_date) >= 2004 and year(release_date) <= 2008;
where year(release_date) between 2004 and 2008;

select title, rating, awards
from movies
where rating > 3
and awards > 1
and year(release_date) between 1988 and 2009
order by rating;

insert into actors values (null, null, null, 'Armando', 'Santos', 5.7, 1);

update actors 
set last_name = 'Ferreira'
where id = 50;

delete from actors
where id = 50;



-- criacao de tabela temporaria
-- dura enquanto durar a conexao com o banco
create temporary table actors_names
select first_name, last_name
from actors
where rating > 5;

select * from actors_names;


-- contando registros
select count(*) from genres;
select count(*) from movies;

-- encontrado os nulos
select title from movies where genre_id is null;

-- usando duas tabelas
select * from movies, genres; -- da errado porque combina todos os registros das duas tabelas (PRODUTO CARTESIANO)
-- correto
select * from movies, genres
where movies.genre_id = genres.id;

-- reescrevendo com join
-- liste os filmes (que possuem classificacao) e seus nomes de classificacao
select * 
from movies
join genres
on movies.genre_id = genres.id;

-- liste todos os filmes e seus nomes de classificacao, inclusive sem classificacao
select * 
from movies
left join genres -- inclui tudo que é igual + os que estao em nulo (movies)
on movies.genre_id = genres.id;

-- liste todas as classificacoes e os filmes correspondentes
select * 
from movies
right join genres -- inclui tudo que é igual + os que estao em nulo (genres)
on movies.genre_id = genres.id;



-- GROUP BY

-- quantas temporadas existem pra cada série (agrupar por temporada)
select series.title, count(*) as temporadas
from seasons inner join series
on series.id = seasons.serie_id -- foreign key da tabela de relacionamento com a primary key 
group by series.id;

-- quantas temporadas existem pra The walking dead
select series.title, count(*) as temporadas
from seasons inner join series
on series.id = seasons.serie_id 
where series.title like '%The Walking Dead%'
group by series.id;

-- quais series tem mais que 5 temporadas
select series.title, count(*) as temporadas
from seasons inner join series
on series.id = seasons.serie_id 
group by series.id
having temporadas > 5;

-- quais sao as 3 series com maior numero de temporadas
select series.title, count(*) as temporadas
from seasons inner join series
on series.id = seasons.serie_id 
group by series.id
order by temporadas desc
limit 3;


-- SUBCONSULTAS
-- resolve da subconsulta pra consulta maior

-- quais os atores que trabalham em filmes com avaliacao maior que 9.1
select *
from actors
where id in (select actor_movie.actor_id
from movies inner join actor_movie on movies.id = actor_movie.movie_id
where rating > 9.1);
-- 1. consulta interna: selecionar os ids dos atoers que trabalham em filmes com avaliacao maior que 9.1
-- 2. a partir da resposta anterior, listar atores cujo id retornou na lista gerada no passo 1

-- outra forma, usando só o join
select first_name, last_name
from movies inner join actor_movie on movies.id = actor_movie.movie_id
			inner join actors on actors.id = actor_movie.actor_id
where movies.rating > 9.1
order by first_name;

-- ordenado por avaliacao do ator
select first_name, last_name, actors.rating as 'avaliação do ator'
from movies inner join actor_movie on movies.id = actor_movie.movie_id
			inner join actors on actors.id = actor_movie.actor_id
where movies.rating > 9.1
order by actors.rating desc;

-- qual filme nao é o preferido de nenhum ator usando NOT EXISTS
select movies.title
from movies
where not exists (select actors.first_name
				  from actors
				  where favorite_movie_id = movies.id);



--------------

-- adicione um filme na tabela de filmes
insert into movies values (null, now(), null, 'Interestelar', 10.0, 5, '2001-04-15', 3, 5); -- now pega a hora atual do sistema
select * from movies;

-- Adicione um gênero à tabela de gêneros.
insert into genres values (null, now(), null, 'Magia', 13, 1);
select * from genres;

-- Associe o filme inserido no item  1. com o gênero criado item 2.
update movies
set genre_id = 19, updated_at = now()
where id = 22;

-- Modifique a tabela de atores para que pelo menos um ator tenha o filme adicionado item 1 como favorito.
update actors
set favorite_movie_id = 22
where id = 12;

select * from actors;

-- Crie uma tabela temporária da tabela filmes.
create temporary table movies_tmp
select *
from movies;
-- where rating > 5;

select * from movies_tmp;

-- Elimine da tabela temporária do item 5 todos os filmes que ganharam menos de 5 prêmios.
delete from movies_tmp
where awards < 5;

-- Obtenha a lista de todos os gêneros que possuem pelo menos um filme.
select distinct name -- pra nao duplicar valor
from genres
inner join movies
on genres.id = movies.genre_id;

-- Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios.
select first_name, last_name
from actors
inner join movies
on actors.favorite_movie_id = movies.id
where movies.awards > 3;

-- Crie um índice no nome na tabela de filmes. Verifique se o índice foi criado corretamente.
create index indx_movies_title on movies(title);
-- alter table movies add constraint unique (title);