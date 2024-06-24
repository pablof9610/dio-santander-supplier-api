package me.dio.domain.repository;

import me.dio.domain.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    boolean existsByZipCode(String zipCode);
}
