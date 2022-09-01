package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Factura;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Factura.FacturaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Facturas")
public class FacturaController {
    @Autowired
    private FacturaServiceInterface facturaService;

    //Facturas
    @GetMapping("")
    private ResponseEntity<?> getFacturas(){return ResponseEntity.ok(facturaService.getFacturas());
    }
    @GetMapping("/{id}")
    private ResponseEntity<?> getFacturaById(@PathVariable Integer id){return ResponseEntity.ok(facturaService.getFacturaById(id));
    }
    @GetMapping("/{date}")
    private ResponseEntity<?> getFacturaByFecha(@PathVariable Date date){return ResponseEntity.ok(facturaService.getFacturaByFecha(date));
    }
    @PostMapping("/Nueva")
    private ResponseEntity<?> postFactura(@RequestBody Factura factura) throws ApiException {return ResponseEntity.ok(facturaService.postFactura(factura));
    }
    @PutMapping("/Actualizar")
    private ResponseEntity<?> updateFactura(@RequestBody Factura factura) throws ApiException {return ResponseEntity.ok(facturaService.updateFactura(factura));
    }
    @DeleteMapping("/Borrar/{id}")
    private ResponseEntity<?> deleteFactura(@PathVariable Integer id) throws ApiException {return ResponseEntity.ok(facturaService.delete(id));
    }
}
