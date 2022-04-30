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
import br.com.brasileirao.model.entity.Time;
import br.com.brasileirao.service.TimeService;

@RestController
@RequestMapping("/api/v1/times")
public class TimeController {
	
	@Autowired
	private TimeService service;
	
    @GetMapping
    public List<Time> listar() {
        return service.findAll();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public Time salvar(@RequestBody Time time) {
        return service.save(time);
    }
    
    @PutMapping
    public Time editar(@RequestBody Time time) {
        return service.editar(time);
    }
    
    @DeleteMapping("{id}")
    public void deletarPorId(@PathVariable Integer id) {
    	Time time = service.findById(id);
        service.excluir(time);
    }

}
