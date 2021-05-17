package com.tecnocode.repository;

import com.tecnocode.model.Address;
import com.tecnocode.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("SELECT c FROM Company c WHERE c.address like :address")
    List<Company> findAllByAddress(@Param("address") Address address);

    @Query("SELECT c FROM Company c WHERE c.name like %:name%")
    List<Company> findAllByName(@Param("name") String name);

    @Query("SELECT c FROM Company c WHERE c.cnpj like :cnpj")
    List<Company> findAllByCnpj(@Param("cnpj") String cnpj);

}
