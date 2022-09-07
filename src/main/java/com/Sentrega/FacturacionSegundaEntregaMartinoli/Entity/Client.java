package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Client")
public class Client {

    @Id
    @Column( name = "ClientId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clientId;
    @Column( name = "name")
    private String name;
    @Column( name ="surname")
    private String surname;
    @Column( name = "dni")
    private Integer dni;
    @NotNull
    @Column( name = "Sex")
    private Character sex;

    public Client() {
    }
}
