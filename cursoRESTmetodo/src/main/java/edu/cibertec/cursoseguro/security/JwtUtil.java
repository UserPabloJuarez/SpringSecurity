package edu.cibertec.cursoseguro.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import static java.util.Collections.emptyList;

public class JwtUtil {

    // Método para crear el JWT y enviarlo al cliente en el header de la respuesta
    static void addAuthentication(HttpServletResponse res, String username) {
        String token = Jwts.builder()
                .setSubject(username)
                // Se asigna un tiempo de expiración de 1 minuto
                .setExpiration(new Date(System.currentTimeMillis() + 60000))
                // Hash con el que firmaremos la clave
                .signWith(SignatureAlgorithm.HS512, "P@tit0")
                .compact();
         //agregamos al encabezado el token
        res.addHeader("Authorization", "Bearer " + token);
    }
    
    // Método para validar el token enviado por el cliente
    static Authentication getAuthentication(HttpServletRequest request) {
        // Obtenemos el token que viene en el encabezado de la petición
        String token = request.getHeader("Authorization");
        // si hay un token presente, entonces se valida
        if (token != null) {
            String user = Jwts.parser()
                    .setSigningKey("P@tit0")
                    .parseClaimsJws(token.replace("Bearer", "")) //este método es el que valida
                    .getBody()
                    .getSubject();
            // Recordamos que para las demás peticiones que no sean /login
            // no requerimos una autenticación por username/password
            // por ese motivo podemos devolver un UsernamePasswordAuthenticationToken sin password
            return user != null
                    ? new UsernamePasswordAuthenticationToken(user, null, emptyList())
                    : null;
        }
        return null;
    }
}
