package pe.edu.cibertec.patitas_bakend_a.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.patitas_bakend_a.dto.LoginReqDTO;
import pe.edu.cibertec.patitas_bakend_a.dto.LoginResponseDTO;
import pe.edu.cibertec.patitas_bakend_a.service.AutenticacionService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {


    @Autowired
    ResourceLoader resourceLoader;


    @Override
    public String[] validarUsuario(LoginReqDTO loginReqDTO) throws Exception {
        String[] datosUsuario = null;
        Resource resource = resourceLoader.getResource("classpath:usuarios.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                if (loginReqDTO.tipoDocumento().equals(datos[0]) &&
                        loginReqDTO.numeroDocumento().equals(datos[1]) &&
                        loginReqDTO.password().equals(datos[2])) {

                    datosUsuario = new String[2];
                    datosUsuario[0] = datos[3]; //recuperar nombre
                    datosUsuario[1] = datos[4]; //recuperar email
                    break;
                }

            }} catch (IOException e) {
            throw new IOException(e);

        }
        return datosUsuario;
    }
}


