package mx.edu.utez.examen1.services.usuarios;

import mx.edu.utez.examen1.models.usuarios.Usuarios;
import mx.edu.utez.examen1.models.usuarios.UsuariosRepository;
import mx.edu.utez.examen1.services.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


import java.sql.SQLException;

@Service
public class UsuariosService {
    @Autowired
    private UsuariosRepository repository;


    @Transactional(readOnly = true)
    public CustomResponse<List<Usuarios>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(readOnly = true)
    public CustomResponse<Usuarios> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Usuarios> insert(Usuarios user){
        if(this.repository.existsByNombre(user.getNombre()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "ya se encuentra registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(user),
                false,
                200,
                "registrado correctamente"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Usuarios> update(Usuarios user){
        if(!this.repository.existsById(user.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El usuario no se encuentra registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(user),
                false,
                200,
                "Usuario actualizado correctamente"
        );
    }
}
