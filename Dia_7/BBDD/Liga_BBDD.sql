--  ___      ___   _______  _______ 
-- |   |    |   | |       ||   _   |
-- |   |    |   | |    ___||  |_|  |
-- |   |    |   | |   | __ |       |
-- |   |___ |   | |   ||  ||       |
-- |       ||   | |   |_| ||   _   |
-- |_______||___| |_______||__| |__|

USE b9qcamqr62f6m9ud9dpx;

CREATE TABLE partido(
	id_partido INT AUTO_INCREMENT PRIMARY KEY,
    equipo_local VARCHAR(200),
    equipo_visitante VARCHAR(200),
    cestas_local INT,
    cestas_visitante INT,
    finalizado BOOLEAN,
    fecha DATE
);

CREATE TABLE liga(
	id_liga INT AUTO_INCREMENT PRIMARY KEY, 
    id_partido INT,
    FOREIGN KEY (id_partido) REFERENCES  partido(id_partido),
    jornada INT
);

CREATE TABLE playoffs(
	id_playoffs INT AUTO_INCREMENT PRIMARY KEY,
	id_partido INT,
    FOREIGN KEY (id_partido) REFERENCES  partido(id_partido),
    ronda VARCHAR(100)
);

-- Ver tablas
SELECT * FROM partido;
SELECT * FROM liga;
SELECT * FROM playoffs;

-- Insertar datos 
INSERT INTO partido (equipo_local, equipo_visitante, cestas_local, cestas_visitante, finalizado, fecha) VALUES 
("Los Angeles Lakers", "Chicago Bulls", 30, 15, TRUE, "2024-06-17"),
("Boston Celtics", "Miami Heat", 20, 25, TRUE, "2024-05-22"),
("Minnesota Timberwolves", "Charlotte Hornetss", 15, 15, FALSE, "2024-07-10");

INSERT INTO liga(id_partido, jornada) VALUES (2,2);

INSERT INTO playoffs(id_partido, ronda) VALUES (3,"Cuartos");

-- Consultas
SELECT * 
FROM partido as p
INNER JOIN liga as l On l.id_partido = p.id_partido;

SELECT * 
FROM partido as p
INNER JOIN playoffs as po On po.id_partido = p.id_partido;