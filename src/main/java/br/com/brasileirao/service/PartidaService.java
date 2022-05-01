package br.com.brasileirao.service;


import br.com.brasileirao.model.entity.Evento;
import br.com.brasileirao.model.entity.Jogador;
import br.com.brasileirao.model.entity.Partida;
import br.com.brasileirao.model.entity.Time;
import br.com.brasileirao.model.repository.EventoRepository;
import br.com.brasileirao.model.repository.JogadorRepository;
import br.com.brasileirao.model.repository.PartidaRepository;
import br.com.brasileirao.model.repository.TimeRepository;

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
    
    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private JogadorRepository jogadorRepository;
    

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

    public List<Evento> findEventosByPartidaId(Integer id) {
        Optional<Partida> partida = this.repository.findById(id);

        if (partida.isEmpty())
            return null;

        return this.eventoRepository.findByPartidaId(partida.get().getId());
    }
    
    public boolean handleEventOnPartida(Integer id, String eventName) {
        Optional<Partida> partidaFound = this.partidaRepository.findById(id);

        if (partidaFound.isEmpty())
            return false;

        if ("inicio".equals(eventName))
            this.createInicioEvent(partidaFound.get());
        else if ("fim".equals(eventName))
            this.createFimEvent(partidaFound.get());
        else if ("intervalo".equals(eventName))
            this.createIntervaloEvent(partidaFound.get());
        else if ("acrescimo".equals(eventName))
            this.createAcrescimoEvent(partidaFound.get());

        return true;
    }

    public boolean handleEventOnPartida(Integer id, Integer timeId, Integer jogadorId, String jogadorNameEntra, String eventName) {
        Optional<Partida> partidaFound = this.partidaRepository.findById(id);

        if (partidaFound.isEmpty())
            return false;

        Optional<Time> timeFound = this.timeRepository.findById(timeId);

        if (timeFound.isEmpty())
            return false;

        Optional<Jogador> jogadorFound = this.jogadorRepository.findById(jogadorId);

        if (jogadorFound.isEmpty())
            return false;

        if ("gol".equals(eventName))
            this.createGolEvent(partidaFound.get(), jogadorFound.get(), timeFound.get());
        else if ("substituicao".equals(eventName))
            this.createSubstituicaoEvent(partidaFound.get(), timeFound.get(), jogadorFound.get(), jogadorNameEntra);
        else if ("advertencia".equals(eventName))
            this.createAdvertenciaEvent(partidaFound.get(), timeFound.get(), jogadorFound.get());
        else
            return false;

        return true;
    }

    public void createGolEvent(Partida partida, Jogador jogador, Time time) {
        this.eventoRepository.save(new Evento("gol", jogador, time, partida, null));
    }

    public void createInicioEvent(Partida partida) {
        this.eventoRepository.save(new Evento("inicio", null, null, partida, null));
    }

    public void createIntervaloEvent(Partida partida) {
        this.eventoRepository.save(new Evento("intervalo", null, null, partida, null));
    }

    public void createAcrescimoEvent(Partida partida) {
        this.eventoRepository.save(new Evento("acrescimo", null, null, partida, null));
    }

    public void createSubstituicaoEvent(Partida partida, Time time, Jogador jogador, String jogadorNameEntra) {
        this.eventoRepository.save(new Evento("substituicao", jogador, time, partida, jogadorNameEntra));
    }

    public void createAdvertenciaEvent(Partida partida, Time time, Jogador jogador) {
        this.eventoRepository.save(new Evento("advertencia", jogador, time, partida, null));
    }

    public void createFimEvent(Partida partida) {
        this.calculateAndProcessWinner(partida);
        this.eventoRepository.save(new Evento("fim", null, null, partida, null));
    }

    public void calculateAndProcessWinner(Partida partida) {
        Long teamOneCount = this.eventoRepository.countByNameAndPartidaIdAndTimeId("gol", partida.getId(), partida.getTimeUm().getId());
        Long teamTwoCount = this.eventoRepository.countByNameAndPartidaIdAndTimeId("gol", partida.getId(), partida.getTimeDois().getId());

        if (teamOneCount > teamTwoCount)
            partida.setVencedor(partida.getTimeUm());
        else if (teamOneCount < teamTwoCount)
            partida.setVencedor(partida.getTimeDois());
        else
            return;

        this.partidaRepository.save(partida);
    }
}
