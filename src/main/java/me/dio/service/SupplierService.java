package me.dio.service;

import me.dio.domain.model.Supplier;

public interface SupplierService {

    Supplier findById(Long id);

    Supplier create(Supplier supplierToCreate);
}
