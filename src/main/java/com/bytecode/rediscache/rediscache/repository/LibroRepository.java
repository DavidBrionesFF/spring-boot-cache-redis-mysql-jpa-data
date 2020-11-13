package com.bytecode.rediscache.rediscache.repository;

import com.bytecode.rediscache.rediscache.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface LibroRepository extends PagingAndSortingRepository<Libro, Serializable> {
}
