package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Invoice")
public class Invoice implements Serializable {
    @Id
    @NotNull
    @Column(name = "InvoiceId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer InvoiceId;
    @NotNull
    @Column(name = "clientId")
    private Integer clientId;
    @NotNull
    @Column(name = "productId")
    private List<Integer> productsId = new ArrayList<Integer>();
    @NotNull
    @Column(name = "Date")
    private Date date;
    @Column(name = "TotalValue")
    private Double totalValue;
    @Column(name = "paymentMethod")
    private String paymentMethod;

    public Invoice() {
    }
}
