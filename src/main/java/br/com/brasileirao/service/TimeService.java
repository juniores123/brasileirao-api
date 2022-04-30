package br.com.brasileirao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasileirao.model.entity.Time;
import br.com.brasileirao.model.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;
	
    public List<Time> findAll() {       
        return repository.findAll();
    }

    public Time findById(int id) {        
        return repository.findById(id).get();
    }

    public Time save(Time time) {        
        return repository.save(time);
    }
    
    public Time editar(Time time) {        
        return repository.save(time);
    }
    
    public void excluir(Time time) {
    	repository.delete(time);
    }

}
