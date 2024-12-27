package com.nogran.food.api.controller;

import com.nogran.food.domain.exception.EntidadeEmUsoException;
import com.nogran.food.domain.exception.EntidadeNaoEncontradaException;
import com.nogran.food.domain.model.Cidade;
import com.nogran.food.domain.service.CidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cidades")
@RestController
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeService.listar();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
        Cidade cidade = cidadeService.buscarPorId(cidadeId);
        if (cidade != null) {
            return ResponseEntity.ok(cidade);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
        try {
            cidade = cidadeService.adicionar(cidade);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(cidade);
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<?> atualizar(@PathVariable Long cidadeId,
                                       @RequestBody Cidade cidade) {
        try {
            Cidade cidadeAtual = cidadeService.buscarPorId(cidadeId);
            if (cidadeAtual != null) {
                BeanUtils.copyProperties(cidade, cidadeAtual, "id");
                cidadeAtual = cidadeService.adicionar(cidadeAtual);
                return ResponseEntity.ok(cidadeAtual);
            }
            return ResponseEntity.notFound().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId) {
        try {
            cidadeService.remover(cidadeId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }

}
