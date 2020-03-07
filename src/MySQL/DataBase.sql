
Create database BD_Multa;

use BD_Multa;

create table multas (
DNI int,
multa varchar(50),
monto numeric(6,2),
correo varchar(50)
);

insert into multas values (78965410,'Alta Velocidad',450,'juanperez@yahoo.es');
insert into multas values (0542698,'Pico placa',320,'maria123@hotmail.com');
insert into multas values (78965410,'Alta Velocidad',450,'edgardoxx*@gmail.com');
insert into multas values (78965410,'Alta Velocidad',450,'robertoeo@gmail.com');