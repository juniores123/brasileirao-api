package br.com.brasileirao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasileirao.model.entity.Transferencia;
import br.com.brasileirao.model.repository.TransferenciaRepository;

@Service
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository repository;
	
    public List<Transferencia> findAll() {       
        return repository.findAll();
    }

    public Transferencia findById(int id) {        
        return repository.findById(id).get();
    }

    public Transferencia save(Transferencia transferencia) {        
        return repository.save(transferencia);
    }
    
    public Transferencia editar(Transferencia transferencia) {        
        return repository.save(transferencia);
    }
    
    public void excluir(Transferencia transferencia) {
    	repository.delete(transferencia);
    }

}
