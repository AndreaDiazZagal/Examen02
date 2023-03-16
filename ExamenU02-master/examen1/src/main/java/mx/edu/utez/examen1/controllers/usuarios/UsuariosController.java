package mx.edu.utez.examen1.controllers.usuarios;


import mx.edu.utez.examen1.models.usuarios.Usuarios;
import mx.edu.utez.examen1.models.usuarios.UsuariosRepository;
import mx.edu.utez.examen1.services.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import javax.validation.Valid;

@RestController
@RequestMapping("/api-examenordianrio/user/")
@CrossOrigin(origins = {"*"})
public class UsuariosController {
    @Autowired
    private UsuariosRepository service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Usuarios>>> getAll(){
        return new ResponseEntity<>(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @PutMapping("/")
    public ResponseEntity<CustomResponse<Usuarios>> update(
            @Valid BindingResult result){
        if(result.hasErrors()){
            return new ResponseEntity<>(
                    null,
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
