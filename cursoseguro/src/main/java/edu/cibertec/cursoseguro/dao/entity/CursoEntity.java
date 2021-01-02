package edu.cibertec.cursoseguro.dao.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "curso")
@Data
public class CursoEntity {

    @Id
    @Column(name = "idcurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCurso;
    @Column(name = "nomcurso")
    private String nomCurso;
    @Column(name = "fechainicio")
    private Date fechaInicio;
    @Column(name = "alumnosmin")
    private int alumnosMin;
    @Column(name = "alumnosact")
    private int alumnosAct;
    @Column(name = "estado")
    private int estado;
}
