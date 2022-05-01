package br.com.brasileirao.service;


import br.com.brasileirao.model.entity.Evento;
import br.com.brasileirao.model.entity.Partida;
import br.com.brasileirao.model.repository.EventoRepository;
import br.com.brasileirao.model.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository repository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<Partida> findAll() {
        return this.repository.findAll();
    }

    public Optional<Partida> findById(int id) {
        return this.repository.findById(id);
    }

    public Partida save(Partida partida) {
        return this.repository.save(partida);
    }

    public Partida update(Partida partida) {
        return this.repository.save(partida);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }

    public boolean createEventOnPartida(Integer id, String nameEvento) {
        Optional<Evento> evento = this.eventoRepository.findByName(nameEvento);

        if (evento.isEmpty()) {
            return false;
        }

        Optional<Partida> partidaFound = this.repository.findById(id);

        if (partidaFound.isEmpty()) {
            return false;
        }

        Partida currentPartida = partidaFound.get();

        // Grab the existent eventos in partida
        List<Evento> currentEventos = currentPartida.getEventos();
        currentEventos.add(evento.get());
        currentPartida.setEventos(currentEventos);

        return true;
    }
}
