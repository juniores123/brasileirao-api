package br.com.brasileirao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasileirao.model.entity.Jogador;
import br.com.brasileirao.model.repository.JogadorRepository;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorRepository repository;
	
    public List<Jogador> findAll() {       
        return repository.findAll();
    }

    public Jogador findById(int id) {        
        return repository.findById(id).get();
    }

    public Jogador save(Jogador jogador) {        
        return repository.save(jogador);
    }
    
    public Jogador editar(Jogador jogador) {        
        return repository.save(jogador);
    }
    
    public void excluir(Jogador jogador) {
    	repository.delete(jogador);
    }

}
