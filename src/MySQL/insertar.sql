DELIMITER $$
CREATE PROCEDURE insertar_multa(
IN IDNI INT,
IN Imulta VARCHAR(50),
IN Imonto numeric(6,2),
IN Icorreo VARCHAR(50),
)
BEGIN
    insert into multas(DNI,multa,monto,correo) 
    values (IDNI,Imulta,Imonto,Icorreo);
END$$
DELIMITER ;