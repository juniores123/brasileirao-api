package br.com.brasileirao.controller;


import br.com.brasileirao.model.entity.Partida;
import br.com.brasileirao.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/partidas")
public class PartidasController {

    @Autowired
    private PartidaService service;

    @GetMapping
    public List<Partida> list() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Partida> findOne(@PathVariable Integer id) {
        Optional<Partida> partida = this.service.findById(id);

        if (partida.isEmpty())
            return ResponseEntity.noContent().build();

        return ResponseEntity.ok(partida.get());
    }

    @PostMapping
    public Partida create(@RequestBody Partida partida) {
        return this.service.save(partida);
    }

    @PutMapping
    public Partida update(@RequestBody Partida partida) {
        return this.service.update(partida);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }
}
