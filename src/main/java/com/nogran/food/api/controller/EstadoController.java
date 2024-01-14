package com.nogran.food.api.controller;

import com.nogran.food.domain.model.Estado;
import com.nogran.food.domain.repository.EstadoRepository;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;

    public List<Estado> listar(){
        return estadoRepository.listar();
    }

}
