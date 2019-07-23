/* ENTITÁ */

CREATE TABLE `autostrada` (
    id int auto_increment,
    nome varchar(50),
    citta_uno varchar(30) NOT NULL,
    citta_due varchar(30) NOT NULL,
    tipo int NOT NULL CONSTRAINT CHECK(tipo < 3 && tipo >= 0),       /* 0 = pianura, 1 = montagna */
    primary key(id)
);

CREATE INDEX tipo_index ON autostrada(tipo);

CREATE TABLE `tariffa_autostradale` (
    autostrada_id int,
    tariffaA float NOT NULL,
    tariffaB float NOT NULL,
    tariffa3 float NOT NULL,
    tariffa4 float NOT NULL,
    tariffa5 float NOT NULL,
    foreign key(autostrada_id)references autostrada(id),
    primary key(autostrada_id)
);

CREATE TABLE `tariffa_tipo_autostrada` (
    tariffa float NOT NULL,
    autostrada_tipo int CONSTRAINT CHECK(autostrada_tipo < 3 && autostrada_tipo >= 0),
    foreign key(autostrada_tipo)references autostrada(tipo),
    primary key(autostrada_tipo)
);

CREATE TABLE `casello`(
    id int auto_increment,
    autostrada_id int,
    nome varchar(30) NOT NULL,
    comune_appartenenza varchar(30),
    chilometro float NOT NULL,
    foreign key(autostrada_id)references autostrada(id),
    primary key (id)
);

CREATE TABLE `automobile_con_telepass` (
    targa varchar(10),
    primary key (targa)
);

CREATE TABLE `ingresso_telepass` (
    automobile_telepass_targa varchar(10),
    casello_id int NOT NULL,
    foreign key(automobile_telepass_targa)references automobile_con_telepass(targa),
    foreign key(casello_id)references casello(id),
    primary key (automobile_telepass_targa)
);