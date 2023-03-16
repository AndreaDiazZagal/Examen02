package mx.edu.utez.examen1.services.productos;

import mx.edu.utez.examen1.models.productos.Productos;
import mx.edu.utez.examen1.models.productos.ProductosRepository;
import mx.edu.utez.examen1.services.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


import javax.transaction.Transactional;

@Service
@Transactional
public class ProductosService {
    @Autowired
    private ProductosRepository repository;


    @Transactional(readOnly = true)
    public CustomResponse<List<Productos>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(readOnly = true)
    public CustomResponse<Productos> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,
                200,
                "Ok"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Productos> insert(Productos products){
        if(this.repository.existsByNombre(products.getNombre()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "Producto ya esta registrado"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(products),
                false,
                200,
                "Producto registrado correctamente"
        );
    }


    @Transactional(rollbackFor =  {SQLException.class})
    public CustomResponse<Productos> update(Productos products){
        if(!this.repository.existsById(products.getId()))
            return new CustomResponse<>(
                    null,
                    true,
                    400,
                    "El porducto no se encuentra"
            );
        return new CustomResponse<>(
                this.repository.saveAndFlush(products),
                false,
                200,
                "Producto actualizado correctamente"
        );
    }

}
