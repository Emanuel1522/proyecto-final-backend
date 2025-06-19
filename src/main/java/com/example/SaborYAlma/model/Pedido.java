package com.example.SaborYAlma.model;

import com.example.SaborYAlma.helper.EstadoPedido;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Integer id;

    private String telefono;

    @Column(name = "direccion_entrega", nullable = false)
    private String direccionEntrega;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado;

    private LocalDateTime fecha = LocalDateTime.now();


    //Relacion con cliente N-1
    @ManyToOne
    @JoinColumn(name = "fk_cliente", referencedColumnName = "id_cliente")
    @JsonBackReference(value="pedidoCliente")
    private Cliente cliente;

    //Relacion con detalles_pedido 1-N
    @OneToMany(mappedBy = "pedido")
    @JsonManagedReference(value="detallesPedidoPedido")
    private List<DetallesPedido> detallesPedidos;


    public Pedido() {
    }

    public Pedido(Integer id, String telefono, String direccionEntrega, EstadoPedido estado, LocalDateTime fecha) {
        this.id = id;
        this.telefono = telefono;
        this.direccionEntrega = direccionEntrega;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetallesPedido> getDetallesPedidos() {
        return detallesPedidos;
    }

    public void setDetallesPedidos(List<DetallesPedido> detallesPedidos) {
        this.detallesPedidos = detallesPedidos;
    }
}