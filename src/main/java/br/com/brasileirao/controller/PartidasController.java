package br.com.brasileirao.controller;


import br.com.brasileirao.model.entity.Partida;
import br.com.brasileirao.requests.EventoRequest;
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
    
    @PutMapping("{id}/eventos/gol")
    public ResponseEntity<?> golEvent(@PathVariable Integer id, @RequestBody EventoRequest eventoRequest) {
        boolean eventInsertion = this.service.handleEventOnPartida(id, eventoRequest.timeId, eventoRequest.jogadorId, eventoRequest.jogadorNameEntra, "gol");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}/eventos/inicio")
    public ResponseEntity<?> inicioEvent(@PathVariable Integer id) {
        boolean eventInsertion = this.service.handleEventOnPartida(id, "inicio");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}/eventos/fim")
    public ResponseEntity<?> fimEvent(@PathVariable Integer id) {
        boolean eventInsertion = this.service.handleEventOnPartida(id, "fim");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}/eventos/advertencia")
    public ResponseEntity<?> advertenciaEvent(@PathVariable Integer id, @RequestBody EventoRequest eventoRequest) {
        boolean eventInsertion = this.service.handleEventOnPartida(id, eventoRequest.timeId, eventoRequest.jogadorId, eventoRequest.jogadorNameEntra, "advertencia");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}/eventos/substituicao")
    public ResponseEntity<?> substituicaoEvent(@PathVariable Integer id, @RequestBody EventoRequest eventoRequest) {
        boolean eventInsertion = this.service.handleEventOnPartida(id, eventoRequest.timeId, eventoRequest.jogadorId, eventoRequest.jogadorNameEntra, "substituicao");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}/eventos/acrescimo")
    public ResponseEntity<?> acrescimoEvent(@PathVariable Integer id) {
        boolean eventInsertion = this.service.handleEventOnPartida(id,"acrescimo");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }

    @PutMapping("{id}/eventos/intervalo")
    public ResponseEntity<?> intervaloEvent(@PathVariable Integer id) {
        boolean eventInsertion = this.service.handleEventOnPartida(id,"intervalo");

        if (!eventInsertion) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(null);
    }
}
