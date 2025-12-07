INSERT INTO clientes (
    nombre, email, telefono, documento, direccion, fecha_nacimiento,
    genero, membresia, fecha_inicio, fecha_vencimiento, estado,
    visitas, notas, contacto_emergencia, telefono_emergencia,
    fecha_registro, fecha_actualizacion
)
VALUES
-- Cliente 1
('Juan Pérez', 'juan.perez@example.com', '987654321', '12345678',
 'Av. Los Olivos 123', '1990-05-20', 'Masculino', 'Mensual',
 '2025-01-01', '2025-01-31', 'Activa', 5,
 'Cliente frecuente. Prefiere entrenar por la mañana.',
 'María Pérez', '987111222', NOW(), NOW()),

-- Cliente 2
('Ana Torres', 'ana.torres@example.com', '999888777', '87654321',
 'Jr. Primavera 456', '1985-08-15', 'Femenino', 'Trimestral',
 '2024-12-01', '2025-03-01', 'Activa', 12,
 'Le gusta entrenamiento funcional.',
 'Carlos Torres', '912333444', NOW(), NOW()),

-- Cliente 3
('Luis Rojas', 'luis.rojas@example.com', '923456789', '44556677',
 'Av. Arequipa 789', '1992-11-10', 'Masculino', 'Semestral',
 '2024-10-10', '2025-04-10', 'Por Vencer', 20,
 'Ha solicitado rutina personalizada.',
 'Lucía Rojas', '911222333', NOW(), NOW()),

-- Cliente 4
('Carla Fernández', 'carla.fernandez@example.com', '955667788', '99887766',
 'Calle Las Gardenias 321', '1996-01-30', 'Femenino', 'Premium Anual',
 '2024-01-01', '2025-01-01', 'Vencida', 45,
 'Cliente VIP. Acceso a sauna y piscina.',
 'Pedro Fernández', '944333222', NOW(), NOW()),

-- Cliente 5
('Miguel Salazar', 'miguel.salazar@example.com', '912345678', '11223344',
 'Av. Universitaria 654', '1988-03-11', 'Masculino', 'Mensual',
 '2025-01-15', '2025-02-15', 'Activa', 3,
 'Entrena en horarios nocturnos.',
 'Sofía Salazar', '955444333', NOW(), NOW()),

-- Cliente 6
('Rosa Quispe', 'rosa.quispe@example.com', '933221100', '77889900',
 'Jr. San Pedro 987', '1978-07-25', 'Femenino', 'Familiar',
 '2024-11-05', '2025-02-05', 'Por Vencer', 18,
 'Viene con su familia, 3 miembros.',
 'Juan Quispe', '900111222', NOW(), NOW()),

-- Cliente 7
('Alberto Gómez', 'alberto.gomez@example.com', '944556677', '55443322',
 'Av. Colonial 456', '1995-12-12', 'Masculino', 'Trimestral',
 '2024-10-01', '2025-01-01', 'Vencida', 10,
 'Suspende entrenamientos por viaje.',
 'Erika Gómez', '944000111', NOW(), NOW()),

-- Cliente 8
('Lucía Mendoza', 'lucia.mendoza@example.com', '988776655', '66778899',
 'Calle Los Pinos 741', '2000-02-18', 'Femenino', 'Mensual',
 '2025-01-10', '2025-02-10', 'Activa', 1,
 'Recién inscrita.',
 'María Mendoza', '966555444', NOW(), NOW()),

-- Cliente 9
('Jorge Castillo', 'jorge.castillo@example.com', '977665544', '33445566',
 'Av. Grau 555', '1983-09-09', 'Masculino', 'Semestral',
 '2024-07-15', '2025-01-15', 'Por Vencer', 30,
 'Participa en clases de box.',
 'Ricardo Castillo', '955666777', NOW(), NOW()),

-- Cliente 10
('Patricia López', 'patricia.lopez@example.com', '922110099', '22113344',
 'Jr. Las Rosas 159', '1999-04-02', 'Femenino', 'Familiar',
 '2024-05-20', '2025-05-20', 'Activa', 22,
 'Asiste con su pareja e hijos.',
 'José López', '900222333', NOW(), NOW());
