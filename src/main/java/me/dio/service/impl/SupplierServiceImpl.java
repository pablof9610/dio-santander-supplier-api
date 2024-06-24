package me.dio.service.impl;

import me.dio.domain.model.Supplier;
import me.dio.domain.repository.SupplierRepository;
import me.dio.service.SupplierService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Supplier create(Supplier supplierToCreate) {
        if (supplierRepository.existsByZipCode(supplierToCreate.getZipCode())) {
            throw new IllegalArgumentException("This company already exists.");
        }
        return supplierRepository.save(supplierToCreate);
    }
}
