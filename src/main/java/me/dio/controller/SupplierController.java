package me.dio.controller;

import me.dio.domain.model.Supplier;
import me.dio.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Long id) {
        var supplier = supplierService.findById(id);
        return ResponseEntity.ok(supplier);
    }

    @PostMapping()
    public ResponseEntity<Supplier> findById(@RequestBody Supplier supplierToCreate) {
        var supplierCreated = supplierService.create(supplierToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(supplierCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(supplierCreated);
    }

}
