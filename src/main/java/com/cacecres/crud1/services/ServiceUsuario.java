package com.cacecres.crud1.services;

import com.cacecres.crud1.entity.Usuario;
import com.cacecres.crud1.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceUsuario {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }

    public Usuario save(Usuario usuario){
        Usuario newUser = usuarioRepository.save(usuario);
            return newUser;
    }

    public Usuario findByid(Long id){
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario Update (Usuario usuario , Long id){
        Usuario usuarioUpdate = usuarioRepository.getOne(id);
        usuarioUpdate.setName(usuario.getName());
        usuarioUpdate.setLastname(usuario.getLastname());
        usuarioUpdate.setDistrito(usuario.getDistrito());
        return usuarioRepository.save(usuarioUpdate);
    }

    public  Usuario UpdateStatus (Long id){
            Usuario usuarioStatus = usuarioRepository.getOne(id);

            usuarioStatus.setState(!usuarioStatus.isState());

            System.out.println(usuarioStatus.isState());
        return usuarioRepository.save(usuarioStatus);
    }
}
