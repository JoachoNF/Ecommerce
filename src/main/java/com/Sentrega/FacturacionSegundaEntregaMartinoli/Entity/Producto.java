package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@Table(name = "Producto")
public class Producto {

    @Id
    @NotNull
    @Column( name = "Id_Producto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column( name = "Nombre_prod")
    private String nombre;
    @Column( name ="Valor_prod")
    private Double valor_prod;
    @Column( name = "Stock")
    private Long stock;

    public Producto() {
    }
}
