package pe.edu.cibertec.patitas_bakend_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.patitas_bakend_a.dto.LoginReqDTO;
import pe.edu.cibertec.patitas_bakend_a.dto.LoginResponseDTO;
import pe.edu.cibertec.patitas_bakend_a.service.AutenticacionService;

@RestController
@RequestMapping("/autentificacion")
public class AutentificacionController {

    @Autowired
    AutenticacionService autenticacionService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginReqDTO loginReqDTO) {

        try {
           String[] datosUsuario = autenticacionService.validarUsuario(loginReqDTO);
           if (datosUsuario == null) {
               return new LoginResponseDTO("01", "usuario no encontrado", null, null);
           }
           return new LoginResponseDTO("00", "inicio de exitoso correctamente", datosUsuario[0],  datosUsuario[1]);
        } catch (Exception e) {
            return new LoginResponseDTO("99", "inicio de sesion fallido", null, null);
        }
    }
}
