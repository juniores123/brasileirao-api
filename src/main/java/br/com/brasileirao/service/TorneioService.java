package br.com.brasileirao.service;

import br.com.brasileirao.model.entity.*;
import br.com.brasileirao.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TorneioService {
    @Autowired
    private TorneioRepository repository;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private JogadorRepository jogadorRepository;

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
