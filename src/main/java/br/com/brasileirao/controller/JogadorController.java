package br.com.brasileirao.controller;

import java.util.List;

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
import br.com.brasileirao.model.entity.Jogador;
import br.com.brasileirao.service.JogadorService;

@RestController
@RequestMapping("/api/v1/jogadores")
public class JogadorController {
	
	@Autowired
	private JogadorService service;
	
    @GetMapping
    public List<Jogador> listar() {
        return service.findAll();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public Jogador salvar(@RequestBody Jogador jogador) {
        return service.save(jogador);
    }
    
    @PutMapping
    public Jogador editar(@RequestBody Jogador jogador) {
        return service.editar(jogador);
    }
    
    @DeleteMapping("{id}")
    public void deletarPorId(@PathVariable Integer id) {
    	Jogador jogador = service.findById(id);
        service.excluir(jogador);
    }

}

