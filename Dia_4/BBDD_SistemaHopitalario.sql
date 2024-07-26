--  ____   ____   _____   _____  
-- |  _ \ |  _ \ |  __ \ |  __ \ 
-- | |_) || |_) || |  | || |  | |
-- |  _ < |  _ < | |  | || |  | |
-- | |_) || |_) || |__| || |__| |
-- |____/ |____/ |_____/ |_____/ 
 
CREATE DATABASE sistema_hospitalario;
USE sistema_hospitalario;

CREATE TABLE hospital (
	id INT AUTO_INCREMENT PRIMARY KEY,
    H_nombre VARCHAR(100),
    H_direccion VARCHAR(100)
);

CREATE TABLE persona (
	id INT AUTO_INCREMENT PRIMARY KEY,
    P_nombre VARCHAR(100),
    P_direccion VARCHAR(100)
);

CREATE TABLE departamento (
	id INT AUTO_INCREMENT PRIMARY KEY,
    D_nombre VARCHAR(100),
    id_hospital INT,
    FOREIGN KEY(id_hospital) REFERENCES hospital(id)
);

CREATE TABLE pabellon (
	id INT AUTO_INCREMENT PRIMARY KEY,
    P_nombre VARCHAR(100),
    capacidad INT,
    id_hospital INT,
    FOREIGN KEY(id_hospital) REFERENCES hospital(id)
);

CREATE TABLE personal (
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT,
    FOREIGN KEY(id_persona) REFERENCES persona(id),
    id_departamento INT,
    FOREIGN KEY(id_departamento) REFERENCES departamento(id),
    fecha_vinculacion DATE,
    tipo ENUM("Administrativo","Tecnico","Operaciones"),
    especialidad VARCHAR(100),
    salario DECIMAL(10,2)
);

CREATE TABLE paciente (
	id INT AUTO_INCREMENT PRIMARY KEY,
    id_persona INT,
    FOREIGN KEY(id_persona) REFERENCES persona(id),
    id_pabellon INT,
    FOREIGN KEY(id_pabellon) REFERENCES pabellon(id),
    fecha_nacimiento DATE,
    fecha_ingreso DATE
);

SHOW TABLES;

INSERT INTO hospital (H_nombre,H_direccion) VALUES ("Hospital Universitario","Calle 15B # 17-25");

SELECT * FROM hospital;