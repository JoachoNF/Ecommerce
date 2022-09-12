package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Invoice;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Invoice.InvoiceServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/Invoice")
public class InvoiceController {
    @Autowired
    private InvoiceServiceInterface invoiceService;
    @GetMapping("")
    private ResponseEntity<?> getAllInvoices(){return ResponseEntity.ok(invoiceService.getAllInvoices());
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getInvoiceById(@PathVariable Integer id){return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }
    @GetMapping("/Client{id}")
    private ResponseEntity<?> getInvoicesByClientId(@PathVariable Integer clientId){return ResponseEntity.ok(invoiceService.getInvoiceByClientId(clientId));}
    @GetMapping("/{date}")
    private ResponseEntity<?> getInvoiceByDate(@PathVariable Date date){return ResponseEntity.ok(invoiceService.getInvoiceByDate(date));
    }
    @PostMapping("/Create")
    private ResponseEntity<?> postInvoice(@RequestBody Invoice invoice) throws ApiException {
        System.out.println("Controller");
        return ResponseEntity.ok(invoiceService.postInvoice(invoice));
    }
    @PutMapping("/Update")
    private ResponseEntity<?> updateInvoice(@RequestBody Invoice invoice) throws ApiException {return ResponseEntity.ok(invoiceService.updateInvoice(invoice));
    }
    @DeleteMapping("/Delete/{id}")
    private ResponseEntity<?> deleteInvoice(@PathVariable Integer id) throws ApiException {return ResponseEntity.ok(invoiceService.delete(id));
    }
}
