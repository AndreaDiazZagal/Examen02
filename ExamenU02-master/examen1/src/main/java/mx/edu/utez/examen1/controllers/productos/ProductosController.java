package mx.edu.utez.examen1.controllers.productos;

import mx.edu.utez.examen1.models.productos.Productos;
import mx.edu.utez.examen1.services.productos.ProductosService;
import mx.edu.utez.examen1.services.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import javax.validation.Valid;

@RestController
@RequestMapping("/api-examenordianrio/product/")
@CrossOrigin(origins = {"*"})

public class ProductosController {
        @Autowired
        private ProductosService service;

        @GetMapping("/")
        public ResponseEntity<CustomResponse<List<Productos>>> getAll() {
            return new ResponseEntity<>(
                    this.service.getAll(),
                    HttpStatus.OK
            );
        }

        @GetMapping("/{id}")
        public ResponseEntity<CustomResponse<Productos>> getOne(@PathVariable("id") Long id) {
            return new ResponseEntity<>(
                    this.service.getOne(id),
                    HttpStatus.OK
            );
        }

        @PostMapping("/")
        public ResponseEntity<CustomResponse<Productos>> insert(
                 @Valid BindingResult result) {
            if (result.hasErrors()) {
                return new ResponseEntity<>(
                        null,
                        HttpStatus.BAD_REQUEST
                );
            }
            return new ResponseEntity<>(
                    HttpStatus.CREATED
            );
        }

        @PutMapping("/")
        public ResponseEntity<CustomResponse<Productos>> update(
                @Valid BindingResult result) {
            if (result.hasErrors()) {
                return new ResponseEntity<>(
                        null,
                        HttpStatus.BAD_REQUEST
                );
            }
            return new ResponseEntity<>(
                    HttpStatus.CREATED
            );
        }

    }

