if db_id('bd_softplan') is null
	create database bd_softplan
go

use bd_softplan
go

if db_id('aluno') is null
	create table aluno (
		cod_aluno integer identity(1,1) not null,
		nome varchar(255),
		endereco varchar(255),
		cidade varchar(255)

		primary key (cod_aluno)
	)
go

if db_id('disciplina') is null
	create table disciplina (
		cod_disc int identity not null,
		nome_disc varchar(255),
		carga_hor varchar(100)

		primary key (cod_disc)
	)
go

if db_id('professor') is null
	create table professor (
		cod_prof int identity not null,
		nome varchar(255),
		endereco varchar(255),
		cidade varchar(255)

		primary key (cod_prof)
	)
go

if db_id('turma') is null
	create table turma (
		cod_turma int identity not null,
		cod_disc int,
		cod_prof int,
		ano int,
		horario int,

		primary key (cod_turma),
		constraint fk_cod_disc_turma foreign key (cod_disc) references dbo.disciplina (cod_disc),
		constraint fk_cod_prof_turma foreign key (cod_prof) references dbo.professor (cod_prof)
	)
go


if db_id('historico') is null
	create table historico (
		cod_aluno int,
		cod_disc int,
		cod_turma int,
		cod_prof int,
		ano integer, 
		frequencia varchar(10),
		nota numeric(12,2)

		constraint fk_cod_aluno_historico foreign key (cod_aluno) references dbo.aluno (cod_aluno),
		constraint fk_cod_disc_historico foreign key (cod_disc) references dbo.disciplina (cod_disc),
		constraint fk_cod_turma_historico foreign key (cod_turma) references dbo.turma (cod_turma),
		constraint fk_cod_prof_historico foreign key (cod_prof) references dbo.professor (cod_prof)
	)
go



-- insere alunos
insert into aluno (nome, endereco, cidade) 
	values ('Miguel Silva','Rua 01, Bairro 01, Nº 01', 'Ponta Grossa - PR'),('Fernando Souza','Rua 02, Bairro 02, Nº 02', 'Londrina - PR'),
		   ('Felipe Martins','Rua 03, Bairro 03, Nº 03', 'Maringá - PR'),('Michelli Souza','Rua 04, Bairro 04, Nº 04', 'Palmas - TO'),
		   ('Fernanda Santos','Rua 05, Bairro 05, Nº 05', 'Florianópolis - SC'),('Murilo Alves','Rua 06, Bairro 06, Nº 06', 'Brasilia - DF'),
		   ('Victor Santos','Rua 07, Bairro 07, Nº 07', 'Campo Grande - MS'),('Lais Souza','Rua 08, Bairro 08, Nº 08', 'Campinas - SP'),
		   ('Leticia Fernanda','Rua 09, Bairro 09, Nº 09', 'Divinopolis - MG'),('Marcelo Gomes','Rua 10, Bairro 10, Nº 10', 'Boa Vista - RR')
-- select * from aluno
-- drop table aluno


-- insere disciplina 
insert into disciplina (nome_disc, carga_hor)
	values ('Ecologia Humana',60),('Inglês Técnico',40),('Portugues Instrumental',30),('Sociologia Ambiental',45),('Matematica Aplicada',80),
		   ('Geometria',60),('Administração',24),('Gestão da Qualidade',80),('Ética',24),('Direito Administrativo',80)
-- select * from disciplina
-- drop table disciplina

-- insere professor
insert into professor (nome, endereco, cidade) 
	values ('Prof. Raimundo Nonato','Rua 01, Bairro 01, Nº01','Divinopolis - MG'),('Prof. Juscelino Patriota','Rua 02, Bairro 02, Nº02','Boa Vista - RR'),
		  ('Prof. Michael Souza','Rua 03, Bairro 03, Nº03','Campo Grande - MS'),('Profa. Marcia Bretas','Rua 04, Bairro 04, Nº04','Rondonopolis - MT'),
		  ('Prof. Fernando Miguel','Rua 05, Bairro 05, Nº05','Florianópolis - SC'),('Profa. Ingredi Venus','Rua 06, Bairro 06, Nº06','Brasilia - DF')
-- select * from professor
-- drop table professor


-- insere turma
insert into turma (cod_disc,cod_prof,ano,horario) 
	values (2,1,2010,8),(1,1,2010,9),(7,2,2010,8),(6,5,2010,8),(10,2,2010,8),(4,1,2010,8),(6,5,2011,8),(10,2,2012,8),(4,1,2016,8)
-- select * from turma
-- drop table turma

-- insere historico
insert into historico (cod_aluno, cod_disc, cod_turma, cod_prof, ano, frequencia, nota) 
	values (1,2,1,1,2010,'P',5.5),(2,1,2,1,2010,'P',5),(3,7,3,2,2011,'F',7),(1,5,1,1,2012,'P',5.5),(9,6,5,2,2008,'F',4.5),(1,4,4,6,2006,'P',7),(5,10,6,5,2019,'F',7.5),
		   (1,2,1,1,2010,'P',5.5),(2,5,2,1,2009,'P',5),(3,7,3,2,2010,'F',7),(1,5,1,1,2010,'P',5.5),(9,4,6,1,2010,'F',4.5),(1,4,4,6,2010,'P',7),(5,10,4,5,2010,'F',7.5),
		   (1,3,4,5,2010,'P',8.5),(2,10,2,1,2010,'P',5.3),(4,2,1,1,2010,'P',9),(1,3,1,2,2010,'F',3.5),(1,5,6,1,2010,'P',6),(5,4,2,1,2010,'P',7.5)
-- select * from historico
-- drop table historico



-- a) trazer nome, endereço, cidade, código disciplina onde nota < 5 em 2010

select
	t2.nome, t2.endereco,
	t2.cidade,t1.cod_disc 
from bd_softplan.dbo.historico t0
	join bd_softplan.dbo.turma t1 on t1.cod_disc = t0.cod_disc and t1.ano = t0.ano
	join bd_softplan.dbo.aluno t2 on t2.cod_aluno = t0.cod_aluno
where t0.ano = 2010
and t0.nota <= 5



-- b) trazer nome dos alunos aprovados 

select
	t2.nome
from bd_softplan.dbo.historico t0
	join bd_softplan.dbo.turma t1 on t1.cod_disc = t0.cod_disc and t1.ano = t0.ano
	join bd_softplan.dbo.aluno t2 on t2.cod_aluno = t0.cod_aluno
where t0.nota > 5
group by t2.nome




-- c) remover todas as informações do aluno 'Miguel Silva'

delete t0
	--select *
from bd_softplan.dbo.historico t0
	inner join bd_softplan.dbo.aluno t1 on t1.cod_aluno = t0.cod_aluno
where t1.nome = 'Miguel Silva'

delete t0
from bd_softplan.dbo.aluno t0
where t0.nome = 'Miguel Silva'

select * from bd_softplan.dbo.aluno




-- d) substituir todas materias do professor 'Prof. Raimundo Nonato' em 2020 para 'Prof. Juscelino Patriota'

update t0
set t0.cod_prof = 2
	--select *
from bd_softplan.dbo.historico t0
where t0.ano = 2010 
and t0.cod_prof = 1

update t0
set t0.cod_prof = 2
	--select *
from bd_softplan.dbo.turma t0
where t0.ano = 2010
and t0.cod_prof = 1

select * from bd_softplan.dbo.turma t0 where  t0.cod_prof = 2 and t0.ano = 2010
select * from bd_softplan.dbo.historico t0 where  t0.cod_prof = 2 and t0.ano = 2010
select * from bd_softplan.dbo.professor