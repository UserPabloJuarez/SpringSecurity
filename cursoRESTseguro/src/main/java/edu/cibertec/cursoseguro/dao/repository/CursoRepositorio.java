package edu.cibertec.cursoseguro.dao.repository;

import edu.cibertec.cursoseguro.dao.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<CursoEntity, Integer> {
}
