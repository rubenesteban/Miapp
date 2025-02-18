-- Insertar datos en la tabla Persona (si aplicas herencia con Cliente)
INSERT INTO persona (id, nombre, email, telefono) VALUES
(1, 'Juan Pérez', 'juan@example.com', '123456789'),
(2, 'María López', 'maria@example.com', '987654321');

-- Insertar datos en la tabla Cliente
INSERT INTO clientes (id, nombre, email, telefono) VALUES
(1, 'Juan Pérez', 'juan@example.com', '123456789'),
(2, 'María López', 'maria@example.com', '987654321');

-- Insertar datos en la tabla Cuenta
INSERT INTO cuentas (id, numero, tipo, saldo) VALUES
(1, '1234567890', 'Ahorro', 5000.00),
(2, '0987654321', 'Corriente', 1500.00);

-- Insertar datos en la tabla Movimiento
INSERT INTO movimientos (id, tipo, monto, fecha) VALUES
(1, 'Depósito', 1000.00, '2024-02-20'),
(2, 'Retiro', 500.00, '2024-02-21');
