# 🍽️ Sabor y Alma - API REST

Backend desarrollado con **Spring Boot** para gestionar el sistema de pedidos de un restaurante ficticio llamado **Sabor y Alma**. Esta API permite realizar operaciones CRUD completas sobre clientes, pedidos, platos, carritos de compra y más.

---

## 🔧 Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Base de datos relacional
- Maven

---

## 🗂️ Arquitectura del proyecto

El proyecto sigue una **arquitectura en capas**:

- `model` – Entidades JPA con anotaciones de mapeo.
- `repository` – Interfaces que extienden `JpaRepository`.
- `services` – Lógica de negocio y validaciones.
- `controller` – Endpoints REST para el acceso externo.
- `helper` – Mensajes constantes y utilidades.

---

## 📦 Entidades del sistema

- **Cliente**: nombre, apellido, correo, contraseña, etc.
- **Carrito**: vinculado a un cliente.
- **CarritoItem**: items dentro del carrito.
- **Pedido**: generado a partir del carrito.
- **DetallesPedido**: detalle de cada pedido (cantidad, plato).
- **Plato**: nombre, descripción, precio.

---

## 🔄 Endpoints disponibles

> ⚠️ Todos los endpoints aceptan y devuelven JSON.

| Recurso           | Endpoint base         | Métodos disponibles                                               |
|-------------------|------------------------|------------------------------------------------------------------|
| **Cliente**        | `/cliente`             | `POST /cliente`, `GET /cliente`, `GET /cliente/{id}`, `PUT /cliente/{id}`, `DELETE /cliente/{id}` |
| **Carrito**        | `/carrito`             | `POST /carrito`, `GET /carrito`, `GET /carrito/{id}`, `PUT /carrito/{id}`, `DELETE /carrito/{id}` |
| **CarritoItem**    | `/carrito_item`        | `POST /carrito_item`, `GET /carrito_item`, `GET /carrito_item/{id}`, `PUT /carrito_item/{id}`, `DELETE /carrito_item/{id}` |
| **Pedido**         | `/pedido`              | `POST /pedido`, `GET /pedido`, `GET /pedido/{id}`, `PUT /pedido/{id}`, `DELETE /pedido/{id}` |
| **DetallesPedido** | `/detalles_pedido`     | `POST /detalles_pedido`, `GET /detalles_pedido`, `GET /detalles_pedido/{id}`, `PUT /detalles_pedido/{id}`, `DELETE /detalles_pedido/{id}` |
| **Plato**          | `/plato`               | `POST /plato`, `GET /plato`, `GET /plato/{id}`, `PUT /plato/{id}`, `DELETE /plato/{id}` |

---

## 📌 Ejemplo de flujo

1. Crear un cliente.
2. Crear un carrito asociado al cliente.
3. Agregar ítems al carrito.
4. Crear un pedido desde el carrito.
5. Consultar pedidos realizados.
6. Eliminar un ítem o pedido si es necesario.

---

## 👨‍💻 Autor

Desarrollado por Emanuel Rojas Ramirez — Proyecto de portafolio personal.
