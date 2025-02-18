Indicaciones Generales
Usar buenas prácticas y patrones como Repository.
Manejar entidades con JPA / Entity Framework Core.
Manejo adecuado de excepciones.
Realizar mínimo dos pruebas unitarias de los endpoints.
La solución debe ser desplegada en Docker.
Luego de la entrega, habrá una entrevista técnica para defender la solución.
Tecnologías a Usar
Java Spring Boot.
Base de datos relacional.
Postman v9.13.2 / Karate DSL (para validación de APIs).
Requerimientos por Seniority
Junior: Implementar los CRUDs básicos (F1, F2, F3).
SemiSenior: Separar en 2 microservicios (Cliente/Persona y Cuenta/Movimientos), comunicación asincrónica, cumplir F1-F5, opcional F6.
Senior: Igual que SemiSenior, pero incluyendo F6 y F7, con consideraciones de rendimiento, escalabilidad y resiliencia.
Entidades
Persona: Nombre, género, edad, identificación, dirección, teléfono.
Cliente: Hereda de Persona, con clienteID, contraseña, estado.
Cuenta: Número de cuenta, tipo, saldo inicial, estado.
Movimientos: Fecha, tipo de movimiento, valor, saldo.
Funcionalidades del API
F1 - CRUDs para Cliente, Cuenta y Movimiento.
F2 - Registro de movimientos (actualiza saldo, permite positivos/negativos).
F3 - Validación de saldo (alerta si no hay fondos: "Saldo no disponible").
F4 - Reportes por rango de fechas y cliente en formato JSON.
F5 - Pruebas unitarias para la entidad Cliente.
F6 - Pruebas de integración.
F7 - Despliegue en contenedores.
Casos de Uso
Incluyen ejemplos de creación de clientes, cuentas y movimientos. También especifica cómo deben verse los reportes en formato JSON.

Instrucciones de Despliegue
Script SQL para la base de datos.
Verificación con Postman.
Entregables
Repositorio Git público con la solución.
Archivo JSON de Postman para validación.
Entrega antes de la fecha límite por correo.
