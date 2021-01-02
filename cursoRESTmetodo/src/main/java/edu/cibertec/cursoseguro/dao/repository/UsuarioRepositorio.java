package edu.cibertec.cursoseguro.dao.repository;

import edu.cibertec.cursoseguro.dao.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<UsuarioEntity, String> {
}
