package br.com.brasileirao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brasileirao.model.entity.Torneio;
import br.com.brasileirao.model.repository.TorneioRepository;

@Service
public class TorneioService {
    @Autowired
    private TorneioRepository repository;

    public List<Torneio> findAll() {
        return this.repository.findAll();
    }

    public Optional<Torneio> findById(int id) {
        return this.repository.findById(id);
    }

    public Torneio save(Torneio time) {
        return this.repository.save(time);
    }

    public Torneio update(Torneio time) {
        return this.repository.save(time);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }
}
