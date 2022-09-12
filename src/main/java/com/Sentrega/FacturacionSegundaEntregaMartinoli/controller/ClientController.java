package com.Sentrega.FacturacionSegundaEntregaMartinoli.controller;

import com.Sentrega.FacturacionSegundaEntregaMartinoli.Entity.Client;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.Error.ApiException;
import com.Sentrega.FacturacionSegundaEntregaMartinoli.service.Client.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/Clients")
public class ClientController {
    @Autowired
    private ClientServiceInterface clientService;
    @GetMapping("")
    private ResponseEntity<?> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }
    @GetMapping("/id{id}")
    private ResponseEntity<?> getClientById(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }
    @GetMapping("/sex{s}")
    private ResponseEntity<?> getClientBySex(@PathVariable Character s) {
        return ResponseEntity.ok(clientService.getClientsBySex(s));
    }
    @PostMapping("/Create")
    private ResponseEntity<?> postClient(@RequestBody Client client) throws ApiException {
        return ResponseEntity.ok(clientService.postClient(client));
    }
    @PutMapping("/Change")
    private ResponseEntity<?> putClient(@RequestBody Client client) throws ApiException {
        return ResponseEntity.ok(clientService.putClient(client));
    }
    @DeleteMapping("/Delete/{id}")
    private ResponseEntity<?> deleteClient(@PathVariable Integer id) throws ApiException {
        if(id==0){
            ResponseEntity<?> response = ResponseEntity.ok(clientService.getAllClients());
            clientService.deleteAll();
            return response;
        }else{
            return ResponseEntity.ok("Client " + clientService.deleteClient(id) + " deleted");
        }
    }
}
