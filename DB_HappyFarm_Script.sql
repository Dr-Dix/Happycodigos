drop database dbhappyfarm;
create database DBHappyFarm;

use DBHappyFarm;

create table TbUsuario (
cod int primary key not null auto_increment,
cnpj varchar(18) not null,
emailCorp varchar(40),
fone varchar(30),
endereco varchar(30),
bairro varchar(20),
numEnd int,
cidade varchar(20),
estado char(2),
cep varchar(9),
senha varchar(12) not null
); 

create table TbGerenciamentodeSafras (
codSafra int primary key not null auto_increment,
nomeAlimento varchar(20) not null,
tempoColheita varchar(10),
epocaCultivo varchar(20),
qtdPlantou int,
qtdColheu int,
estacao varchar (10)
); 

create table TbFertilizantes (
codFert int primary key not null auto_increment,
nomeFert varchar(500),
caractNutri varchar(500),
compQuimica varchar(20),
tipoDeSolo varchar(30),
estagiodaPlanta varchar(30)
); 

create table TbGerenciamentodePesticidasNaturais (
codPest int primary key not null auto_increment,
regPest varchar(30),
regPragas varchar(30),
regDoencas varchar(30),
regEfeitoEsperado varchar(30),
regEfeitoObtido varchar(30)
); 


INSERT INTO `dbhappyfarm`.`tbusuario`
(`cnpj`,
`emailCorp`,
`fone`,
`endereco`,
`bairro`,
`numEnd`,
`cidade`,
`estado`,
`cep`,
`senha`)
VALUES
("00.000.000/0000-00",
"admin123@adm.com",
11970707070,
"Rua Nárnia",
"neverland",
69,
"Parsagada",
"PR",
00000000,
654321);


select * from TbGerenciamentodePesticidasNaturais;
select * from TbFertilizantes;
select * from TbGerenciamentodeSafras;
select * from TbUsuario;
select cnpj, senha FROM tbusuario 

