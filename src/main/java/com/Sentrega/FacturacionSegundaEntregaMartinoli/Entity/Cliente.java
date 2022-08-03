package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Data
@Table(name = "Cliente")
public class Cliente {

    @Id
    @Column( name = "Id_Cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    @Column( name = "Nombre")
    private String nombre;
    @Column( name ="Apellido")
    private String apellido;
    @Column( name = "DNI")
    private Integer dni;
    @NotNull
    @Column( name = "Sex")
    private Character sex;

    public Cliente() {
    }
}
