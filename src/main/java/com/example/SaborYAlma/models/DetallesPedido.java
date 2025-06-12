package com.example.SaborYAlma.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "detalles_pedidos")
public class DetallesPedido {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalles_pedido")
    private Integer id;

    private Integer cantidad;



    //Relacion con pedido N-1
    @ManyToOne
    @JoinColumn(name = "fk_pedido", referencedColumnName = "id_pedido")
    @JsonBackReference(value="detallesPedidoPedido")
    private Pedido pedido;

    //Relacion con platos N-1
    @ManyToOne
    @JoinColumn(name = "fk_plato", referencedColumnName = "id_plato")
    @JsonBackReference(value="detallesPedidoPlato")
    private Plato plato;



    public DetallesPedido() {
    }

    public DetallesPedido(Integer id, Integer cantidad) {
        this.id = id;
        this.cantidad = cantidad;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}