package com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name="InvoiceXproducts")
public class InvoiceXproducts implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    @NotNull
    @Column(name = "invoiceId")
    private Integer invoiceId;
    @NotNull
    @Column(name = "productId")
    private Integer productId;
    @NotNull
    @Column(name = "value")
    private Integer value;
    @NotNull
    @Column(name = "amount")
    private Integer amount;


}
