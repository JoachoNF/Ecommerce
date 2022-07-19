package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@Table(name = "Factura")
public class Factura {
    @Id
    @NotNull
    @Column(name = "Id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_factura;
    @JoinColumn(name = "Cliente.Id_Cliente")
    @NotNull
    private Integer id_cliente;
    @JoinColumn(name = "Producto.Id_Producto")
    @NotNull
    private Integer id_producto;
    @Column(name = "Fecha")
    @NotNull
    private Date fecha;
    @Column(name = "Valor_Total")
    private Double valor_total;
    @Column(name = "Metodo_Pago")
    private String metodo_pago;

    public Factura() {
    }
}
