package com.example.escuela.repository;

import com.example.escuela.model.Cursada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursadaRepository extends JpaRepository<Cursada, Long> {


}
