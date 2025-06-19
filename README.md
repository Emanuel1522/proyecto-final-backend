# 📚 ClassRoomAPI

API RESTful desarrollada con Spring Boot para la gestión académica de un colegio. Permite registrar estudiantes, profesores, cursos, asignaturas, calificaciones, asistencias y más, integrando relaciones entre entidades y operaciones CRUD.

---

## 🧠 Objetivo

Este proyecto fue desarrollado como parte de mi portafolio personal, con el propósito de demostrar mis habilidades en:

- Arquitectura en capas con Spring Boot.
- Manejo de relaciones entre entidades con JPA/Hibernate.
- Serialización/deserialización de objetos en JSON.
- Desarrollo de APIs RESTful con buenas prácticas.

---

## 🛠️ Tecnologías utilizadas

- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- H2 Database / MySQL
- Postman para pruebas

---

## 📁 Estructura del proyecto

El backend sigue una **arquitectura en capas** con separación clara de responsabilidades:

## 🧩 Entidades principales

| Entidad     | Relaciones clave                                |
|-------------|--------------------------------------------------|
| `User`      | 1:1 con `Student` y `Teacher`                    |
| `Student`   | 1:1 con `User`, 1:N con `Qualification`, `Attendance` |
| `Teacher`   | 1:1 con `User`, 1:N con `Course`                 |
| `Course`    | N:1 con `Teacher`, 1:N con `Subject`, `Attendance` |
| `Subject`   | N:1 con `Course`, 1:N con `Qualification`        |
| `Qualification` | N:1 con `Student` y `Subject`                |
| `Attendance`    | N:1 con `Student` y `Course`                 |
| `Registration`  | 1:1 con `Student` y `Course`                 |

---

## 🚀 Endpoints disponibles

> ⚠️ Todos los endpoints aceptan y devuelven JSON.

| Recurso        | Endpoint base   | Métodos disponibles                            |
|----------------|------------------|------------------------------------------------|
| **User**       | `/user`          | `POST /user/save`, `GET /user/getAll`, `GET /user/getUser/{id}`, `PUT /user/update/{id}`, `DELETE /user/delete/{id}` |
| **Teacher**    | `/teacher`       | `POST /teacher/save`, `GET /teacher/getAll`, `GET /teacher/getTeacher/{id}`, `PUT /teacher/update/{id}`, `DELETE /teacher/delete/{id}` |
| **Student**    | `/student`       | `POST /student/save`, `GET /student/getAll`, `GET /student/getStudent/{id}`, `PUT /student/update/{id}`, `DELETE /student/delete/{id}` |
| **Course**     | `/course`        | `POST /course/save`, `GET /course/getAll`, `GET /course/getCourse/{id}`, `PUT /course/update/{id}`, `DELETE /course/delete/{id}` |
| **Subject**    | `/subject`       | `POST /subject/save`, `GET /subject/getAll`, `GET /subject/getSubject/{id}`, `PUT /subject/update/{id}`, `DELETE /subject/delete/{id}` |
| **Qualification** | `/qualification` | `POST /qualification/save`, `GET /qualification/getAll`, `GET /qualification/getQualification/{id}`, `DELETE /qualification/delete/{id}` |
| **Attendance** | `/attendance`    | `POST /attendance/save`, `GET /attendance/getAll`, `GET /attendance/getAttendance/{id}`, `DELETE /attendance/delete/{id}` |
| **Registration** | `/registration` | `POST /registration/save`, `GET /registration/getAll`, `GET /registration/getRegistration/{id}`, `DELETE /registration/delete/{id}` |

---

## ✅ Funcionalidades implementadas

- CRUD completo en `User`, `Teacher`, `Student`.
- Relaciones correctamente mapeadas (1:1, 1:N, N:1).
- Serialización controlada con `@JsonManagedReference` y `@JsonBackReference`.
- Manejo de errores con `try/catch` y `ResponseEntity`.
- Validaciones básicas.

---
