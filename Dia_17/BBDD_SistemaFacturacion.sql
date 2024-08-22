USE bbz9x7uffmmt980va1ni;

CREATE TABLE Cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    tipo VARCHAR(50)
);

CREATE TABLE Producto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    precio DECIMAL(10, 2)
);

CREATE TABLE Factura (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    total DECIMAL(10, 2),
    FOREIGN KEY (cliente_id) REFERENCES Cliente(id)
);

CREATE TABLE Factura_Producto (
    factura_id INT,
    producto_id INT,
    cantidad INT,
    PRIMARY KEY (factura_id, producto_id),
    FOREIGN KEY (factura_id) REFERENCES Factura(id),
    FOREIGN KEY (producto_id) REFERENCES Producto(id)
);

SELECT * FROM Factura