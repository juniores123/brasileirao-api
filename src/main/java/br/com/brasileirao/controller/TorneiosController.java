package br.com.brasileirao.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brasileirao.model.entity.Torneio;
import br.com.brasileirao.service.TorneioService;

@RestController
@RequestMapping("/api/v1/torneios")
public class TorneiosController {
    @Autowired
    private TorneioService service;

    @GetMapping
    public List<Torneio> list() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Torneio> findOne(@PathVariable Integer id) {
        Optional<Torneio> torneio = this.service.findById(id);

        if (torneio.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(torneio.get());
    }

    @PostMapping
    public Torneio create(@RequestBody Torneio torneio) {
        return this.service.save(torneio);
    }

    @PutMapping
    public Torneio update(@RequestBody Torneio torneio) {
        return this.service.update(torneio);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        this.service.delete(id);
    }
}