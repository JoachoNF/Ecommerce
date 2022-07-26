package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Cliente;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Cliente.ClienteServiceInterface;
import lombok.Data;
import net.bytebuddy.pool.TypePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.util.List;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceInterface clienteService;


    @GetMapping("")
    private ResponseEntity<?> getAllClientes() {
        return ResponseEntity.ok(clienteService.getClientes());
    }
    @GetMapping("/id{id}")
    private ResponseEntity<?> getClienteById(@PathVariable Integer id) {
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }
    @GetMapping("/sex{s}")
    private ResponseEntity<?> getClienteBySex(@PathVariable Character s) {
        return ResponseEntity.ok(clienteService.getClientesBySex(s));
    }
    @PostMapping(value = "/New")
    private ResponseEntity<?> postCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.postCliente(cliente));
    }
    @PutMapping("/Change")
    private ResponseEntity<?> putCliente(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteService.putCliente(cliente));
    }
    @DeleteMapping("/Delete")
    private ResponseEntity<?> deleteCliente(@RequestBody Integer id){
        return ResponseEntity.ok("Cliente " + clienteService.deleteCliente(id) + " Eliminado");
    }


}
