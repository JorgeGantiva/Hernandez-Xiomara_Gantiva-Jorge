
DROP TABLE IF EXISTS ODONTOLOGOS;
CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, N_Matricula INT NOT NULL);

-- para test --

INSERT INTO ODONTOLOGOS (NOMBRE, APELLIDO, N_Matricula,) VALUES ('Jose', 'Suarez', 12468690,), ('Omar', 'Castro', 3543793,);