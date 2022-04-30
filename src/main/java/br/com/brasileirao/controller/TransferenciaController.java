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
import br.com.brasileirao.model.entity.Transferencia;
import br.com.brasileirao.service.JogadorService;
import br.com.brasileirao.service.TransferenciaService;

@RestController
@RequestMapping("/api/v1/transferencias")
public class TransferenciaController {
	
	@Autowired
	private TransferenciaService service;
	
	@Autowired
	private JogadorService jogadorService;
	
    @GetMapping
    public List<Transferencia> listar() {
        return service.findAll();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Transferencia> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public Transferencia salvar(@RequestBody Transferencia transferencia) {
    	Jogador jogador = jogadorService.findById(transferencia.getJogador().getId());
    	jogador.setTime(transferencia.getTimeDestino());
    	jogadorService.save(jogador);
        return service.save(transferencia);
    }
    
    @PutMapping
    public Transferencia editar(@RequestBody Transferencia transferencia) {
        return service.editar(transferencia);
    }
    
    @DeleteMapping("{id}")
    public void deletarPorId(@PathVariable Integer id) {
    	Transferencia transferencia = service.findById(id);
        service.excluir(transferencia);
    }

}
