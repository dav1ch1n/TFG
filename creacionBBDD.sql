Create table Armas(
	id_arma serial primary key not null,
	nombre varchar(300) not null,
	afinidad varchar(300) not null,
	descripcion text not null,
	obtencion text not null
);
Create table Personajes (
	id_personajes serial Primary key not null,
	nombre varchar(300) not null not null,
	arma_inicialFK BIGINT not null,
	habilidad varchar(300) not null,
	descripcion text not null,
	obtencion text not null,
	constraint fk_armas foreign key(arma_inicialFK) references Armas(id_arma)
);

Create table Estadísticas(
	id_personajeFK BIGINT primary key not null,
	maxHp int not null,
	regeneracionHp int not null,
	supercura int not null,
	escudo int not null,
	armadura decimal (3, 2) not null,
	esquivar decimal (3, 2) not null,
	robo_de_vida decimal (3, 2) not null,
	espinas int not null,
	
	danyo decimal (3, 2) not null,
	probabilidad_critico decimal (3, 2) not null,
	velocidad_ataque decimal (3, 2) not null,
	danyo_critico decimal (3, 2) not null,
	cantidad_proyectiles int not null,
	rebote_proyectiles int not null,
	
	tamanyo decimal (3, 2) not null,
	velocidad_proyectil decimal (3, 2) not null,
	duracion decimal (3, 2) not null,
	danyo_elites decimal (3, 2) not null,
	retroceso decimal (3, 2) not null,
	velocidad_movimiento decimal (3, 2) not null,
	
	salto_extra int not null,
	altura_salto int not null, 
	suerte decimal (3, 2) not null,
	dificultad decimal (3, 2) not null,
	
	rango_recogida int not null,
	aumento_XP decimal (3, 2) not null,
	aumento_Oro decimal (3, 2) not null,
	incremento_plata decimal (3, 2) not null,
	aparicion_elites decimal (3, 2) not null,
	multiplicador_potenciadores decimal (3, 2) not null,
	caida_potenciador decimal (3, 2) not null,
	constraint fk_personajes foreign key(id_personajeFK) references Personajes(id_personajes)
);

Create table Libros(
	id_libro serial primary key not null,
	nombre varchar (300) not null,
	descripcion text not null,
	estadistica_subir varchar(300) not null
	
);

Create table Objetos(
	id_objeto serial  primary key not null,
	nombre varchar (300) not null,
	descripcion text not null,
	estadistica_subir varchar(300)
);


