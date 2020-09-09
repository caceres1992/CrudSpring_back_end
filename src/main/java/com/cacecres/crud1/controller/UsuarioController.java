package com.cacecres.crud1.controller;

import com.cacecres.crud1.entity.Usuario;
import com.cacecres.crud1.services.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UsuarioController {


    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/users")
    public List<Usuario> findAll (){
        return serviceUsuario.findAll();
    }


    @GetMapping("/users/{id}")
    public Usuario findAllById (@PathVariable Long id){
        return serviceUsuario.findByid(id);
    }





    @PostMapping("/users")
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        Map<Object,String> response  = new HashMap();
        try {
                    serviceUsuario.save(usuario);
                    response.put("user ",usuario.getName() + " created ");
                    response.put("OK"," SUCCESS ");
        }catch (DataAccessException e){

            response.put("error","error en la peticion");
            response.put("msj",e.getMessage().concat(" / ").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> update(@PathVariable Long id ,@RequestBody Usuario usuario){
        Map<Object,String> response  = new HashMap();
        try {
            serviceUsuario.Update(usuario,id);
            response.put("user ",usuario.getName() + " update ");
            response.put("OK"," SUCCESS ");
        }catch (DataAccessException e){

            response.put("error","error en la peticion");
            response.put("msj",e.getMessage().concat(" / ").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PutMapping("/users/status/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id){
        Map<Object,String> response  = new HashMap();
        try {
            response.put("user "," update Status ");
            serviceUsuario.UpdateStatus(id);
            response.put("OK"," SUCCESS ");
        }catch (DataAccessException e){

            response.put("error","error en la peticion");
            response.put("msj",e.getMessage().concat(" / ").concat(e.getMostSpecificCause().getMessage()));

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
