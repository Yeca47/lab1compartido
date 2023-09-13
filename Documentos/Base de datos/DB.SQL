CREATE TABLE Roles (
    ID_Rol INT AUTO_INCREMENT PRIMARY KEY,
    Nombre_Rol VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE Usuarios (
    ID_Usuario INT AUTO_INCREMENT PRIMARY KEY,
    NombreUsuario VARCHAR(50) NOT NULL UNIQUE,
    Contraseña VARCHAR(255) NOT NULL,
    NombreCompleto VARCHAR(100) NOT NULL,
    ID_Rol INT,
    FOREIGN KEY (ID_Rol) REFERENCES Roles(ID_Rol)
);


CREATE TABLE Clientes (
    ID_Cliente INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Direccion VARCHAR(255) NOT NULL,
    Telefono VARCHAR(15) NOT NULL,
    Email VARCHAR(255)
);

CREATE TABLE Entregas (
    ID_Entrega INT AUTO_INCREMENT PRIMARY KEY,
    ID_Cliente INT,
    Fecha_Entrega DATE,
    Litros_Entregados DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente),
    FOREIGN KEY (ID_Vehiculo) REFERENCES Vehiculos(ID_Vehiculo);
);

CREATE TABLE Totales (
    ID_Cliente INT PRIMARY KEY,
    Total_Litros_Entregados DECIMAL(10, 2),
    FOREIGN KEY (ID_Cliente) REFERENCES Clientes(ID_Cliente)
);

CREATE TABLE Rutas (
    ID_Ruta INT AUTO_INCREMENT PRIMARY KEY,
    ID_Entrega INT,
    Secuencia_Entrega INT,
    FOREIGN KEY (ID_Entrega) REFERENCES Entregas(ID_Entrega)
    ADD FOREIGN KEY (ID_Vehiculo) REFERENCES Vehiculos(ID_Vehiculo);
);

CREATE TABLE Vehiculos (
    ID_Vehiculo INT AUTO_INCREMENT PRIMARY KEY,
    Placa VARCHAR(20) NOT NULL UNIQUE,
    Marca VARCHAR(50) NOT NULL,
    Modelo VARCHAR(50),
    Capacidad_litros DECIMAL(10, 2) NOT NULL
);
