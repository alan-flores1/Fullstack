INSERT INTO usuario (run, nombres, apellidos, fecha_nacimiento, correo, rol) 
VALUES 
('12345678-9', 'Juan', 'Pérez González', '1985-05-12', 'juan.perez@example.com', 'ADMIN');

INSERT INTO usuario (run, nombres, apellidos, fecha_nacimiento, correo, rol) 
VALUES 
('98765432-1', 'María', 'López Ríos', '1990-08-22', 'maria.lopez@example.com', 'USER');

INSERT INTO usuario (run, nombres, apellidos, fecha_nacimiento, correo, rol) 
VALUES 
('11223344-5', 'Carlos', 'Martínez Soto', '1978-11-05', 'carlos.martinez@example.com', 'MODERATOR');

INSERT INTO usuario (run, nombres, apellidos, fecha_nacimiento, correo, rol) 
VALUES 
('22334455-6', 'Ana', 'Gómez Díaz', NULL, 'ana.gomez@example.com', 'GUEST');

INSERT INTO usuario (run, nombres, apellidos, fecha_nacimiento, correo, rol) 
VALUES 
('33445566-7', 'Luis', 'Ramírez Torres', '2000-02-18', 'luis.ramirez@example.com', 'USER');




INSERT INTO evaluacion (nombre_eva, curso_prueba, porcentaje, fecha_prueba) 
VALUES ('Prueba Matemáticas', 'Matemáticas Básicas', 30, '2025-05-20');

INSERT INTO evaluacion (nombre_eva, curso_prueba, porcentaje, fecha_prueba) 
VALUES ('Examen Historia', 'Historia Universal', 50, '2025-06-01');

INSERT INTO evaluacion (nombre_eva, curso_prueba, porcentaje, fecha_prueba) 
VALUES ('Laboratorio Química', 'Química Orgánica', 20, '2025-05-25');

INSERT INTO evaluacion (nombre_eva, curso_prueba, porcentaje, fecha_prueba) 
VALUES ('Proyecto Física', 'Física Clásica', 40, '2025-06-15');

INSERT INTO evaluacion (nombre_eva, curso_prueba, porcentaje, fecha_prueba) 
VALUES ('Evaluación Inglés', 'Inglés Intermedio', 60, '2025-07-05');


INSERT INTO curso_usuario (id_curso, id_usuario, Anotaciones, nota1, nota2, nota3, nota_final) 
VALUES (1, 101, 'Buen desempeño en clases prácticas', 5.5, 6.0, 5.8, 5.76);

INSERT INTO curso_usuario (id_curso, id_usuario, Anotaciones, nota1, nota2, nota3, nota_final) 
VALUES (2, 102, 'Necesita mejorar la participación', 4.2, 4.8, 5.0, 4.67);

INSERT INTO curso_usuario (id_curso, id_usuario, Anotaciones, nota1, nota2, nota3, nota_final) 
VALUES (3, 103, 'Excelente rendimiento en exámenes', 6.5, 6.7, 6.8, 6.67);

INSERT INTO curso_usuario (id_curso, id_usuario, Anotaciones, nota1, nota2, nota3, nota_final) 
VALUES (4, 104, 'Participación activa en clase', 5.0, 5.5, 5.2, 5.23);

INSERT INTO curso_usuario (id_curso, id_usuario, Anotaciones, nota1, nota2, nota3, nota_final) 
VALUES (5, 105, 'Dificultades en comprensión lectora', 3.8, 4.0, 3.5, 3.76);


INSERT INTO curso (nombre, profesor, correo) 
VALUES ('Matemáticas Avanzadas', 'Juan Pérez', 'juan.perez@edutech.com');

INSERT INTO curso (nombre, profesor, correo) 
VALUES ('Historia Contemporánea', 'Ana Gómez', 'ana.gomez@edutech.com');

INSERT INTO curso (nombre, profesor, correo) 
VALUES ('Programación en Java', 'Carlos Ruiz', 'carlos.ruiz@edutech.com');

INSERT INTO curso (nombre, profesor, correo) 
VALUES ('Química Orgánica', 'María Torres', 'maria.torres@edutech.com');

INSERT INTO curso (nombre, profesor, correo) 
VALUES ('Física Cuántica', 'Luis Fernández', 'luis.fernandez@edutech.com');


INSERT INTO reporte (fecha_reporte, tipo_incidencia) 
VALUES ('2025-05-01', 'Falla en conexión');

INSERT INTO reporte (fecha_reporte, tipo_incidencia) 
VALUES ('2025-05-05', 'Error en la evaluación');

INSERT INTO reporte (fecha_reporte, tipo_incidencia) 
VALUES ('2025-05-10', 'Problema de autenticación');

INSERT INTO reporte (fecha_reporte, tipo_incidencia) 
VALUES ('2025-05-12', 'Error en carga de contenido');

INSERT INTO reporte (fecha_reporte, tipo_incidencia) 
VALUES ('2025-05-15', 'Desempeño lento en plataforma');
