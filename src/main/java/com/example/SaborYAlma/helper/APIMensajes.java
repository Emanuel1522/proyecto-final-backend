package com.example.SaborYAlma.helper;

public enum APIMensajes {

    ERROR_CARRITO_NO_ENCONTRADO("El carrito buscado no esta en la base de datos"),
    ERROR_TEACHER_NOT_FOUND("El carrito buscado no esta en la base de datos"),
    ERROR_CARRITO_ITEM_NO_ENCONTRADO("El carrito con items buscados no estan en la base de datos"),
    ERROR_CLIENTE_NO_ENCONTRADO("El cliente buscado no esta en la base de datos"),
    ERROR_DETALLES_PEDIDO_NO_ENCONTRADO("Los detalles del pedido buscados no estan en la base de datos"),
    ERROR_PEDIDO_NO_ENCONTRADO("El pedido buscado no esta en la base de datos"),
    ERROR_PLATO_NO_ENCONTRADO("El plato buscado no esta en la base de datos");

    private String mensaje;

    APIMensajes(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
