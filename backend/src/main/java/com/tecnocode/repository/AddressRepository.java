package com.tecnocode.repository;

import com.tecnocode.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer>{
    @Query("SELECT a FROM Address a WHERE a.city like :city ")
    List<Address> findAllByCity(@Param("city") String city);

    @Query("SELECT a FROM Address a WHERE a.state like :state ")
    List<Address> findAllByState(@Param("state") String state);

    @Query("SELECT a FROM Address a WHERE a.country like :country ")
    List<Address> findAllByCountry(@Param("country") String country);
}
