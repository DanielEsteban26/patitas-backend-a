package pe.edu.cibertec.patitas_bakend_a.service;

import pe.edu.cibertec.patitas_bakend_a.dto.LoginReqDTO;
import pe.edu.cibertec.patitas_bakend_a.dto.LoginResponseDTO;

public interface AutenticacionService {

    String [] validarUsuario(LoginReqDTO loginReqDTO) throws Exception;
}
