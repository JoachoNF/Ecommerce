package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Product")
public class Product {

    @Id
    @NotNull
    @Column( name = "ProductId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @Column( name = "Name")
    private String name;
    @Column( name ="Value")
    private Double value;
    @Column( name = "Stock")
    private Long stock;

    public Product() {
    }
}
