/*int codigo, String descricao, int tempoRestante, double valorAno - INTANGIVEL*/
create table intangivel (codigo int primary key,
							descricao varchar(30) not null,
							tempoRestante int not null,
							valorAno double not null);
							
/*int codigo, String descricao,int quantidade, double valorUnidade - TANGIVEL MOVEL*/
create table tangivelMovel (codigo int primary key,
							descricao varchar(30) not null,
							quantidade int not null,
							valorUnidade double not null);
							
 /*int codigo, String descricao, String localizacao, double tamanho, double valorMetro - TANGIVEL IMOVEL*/
 create table tangivelImovel (codigo int primary key,
							descricao varchar(30) not null,
							localizacao varchar(30) not null,
							tamanho double not null,
							valorMetro double not null);