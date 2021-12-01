SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0
START TRANSACTION;
SET time_zone = "+00:00";


-- Base de datos: "DesafioInventario"

--Estructura de la tabla 'usuarios'

create table 'usuarios'(
    'login' varchar(10) not null,
    'pwd' varchar(10) not null,
    'rol' int(2) not null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Índices de la table usuarios
alter table 'usuarios'(
    ADD PRIMARY KEY ('login')
)


-- Estructura de la tabla dispositivos
create table 'dispositivos'(
    'id' varchar(10) not null,
    'tipo' int(2) not null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Índice de la tabla dispositivo
alter table 'dispositivos'(
)

-- Estrcutura de la tabla Ordenador
create table 'ordenador'(
    'id' varchar(10) not null,
    'cpu' varchar(50) not null,
    'ram' int(3) not null,
    'disco' int(5) not null
)ENGINE=InnoDB DEFAULT CHARSET=latin1;

--Tenemos que añadir la constraint de ordenador.id == dispositivos.id


create table 'monitor'(
    'id' varchar(10) not null,
    'marca' varchar(50) not null,
    'pulgadas' int(3) not null
)

create table 'impresora'(
    'id' varchar(10) not null,
    'marca' varchar(50) not null,
    'fabricacion' int(5) not null
)
