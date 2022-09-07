package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "Invoice")
public class Invoice {
    @Id
    @NotNull
    @Column(name = "InvoiceId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer InvoiceId;
    @NotNull
    @Column(name = "ClientId")
    private Integer clientId;
    @NotNull
    @Column(name = "ProductId")
    private Integer productId;
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
