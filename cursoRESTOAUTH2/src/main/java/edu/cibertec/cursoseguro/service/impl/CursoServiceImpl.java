package edu.cibertec.cursoseguro.service.impl;

import edu.cibertec.cursoseguro.dao.entity.CursoEntity;
import edu.cibertec.cursoseguro.dao.repository.CursoRepositorio;
import edu.cibertec.cursoseguro.service.CursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Override
    public List<CursoEntity> listarTodos() {
        return cursoRepositorio.findAll();
    }

    @Override
    public void insertar(CursoEntity ce) {
        cursoRepositorio.save(ce);
    }

    @Override
    public void eliminar(int codigo) {
        cursoRepositorio.deleteById(codigo);
    }
}
