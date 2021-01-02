package edu.cibertec.cursoseguro;

import edu.cibertec.cursoseguro.dao.entity.UsuarioEntity;
import edu.cibertec.cursoseguro.dao.repository.UsuarioRepositorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class CursoseguroApplicationTests {

    @Autowired
    private UsuarioRepositorio urepo;
    
    @Autowired
    private BCryptPasswordEncoder codificador;
    
	@Test
	void insertarUsuario() {
         UsuarioEntity ue = new UsuarioEntity();
         ue.setUsuario("userNuevo");
         ue.setNombreCompleto("Usuario de prueba");
         ue.setClave(codificador.encode("12345"));
         
         UsuarioEntity a = urepo.save(ue);
         Assertions.assertNotNull(a);
	}

}
