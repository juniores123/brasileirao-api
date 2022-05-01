package br.com.brasileirao.controller;

import br.com.brasileirao.model.entity.Evento;
import br.com.brasileirao.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/eventos")
public class EventosController {

    @Autowired
    private PartidaService partidaService;

    @GetMapping("partidas/{id}")
    public List<Evento> getEventosByPartida(@PathVariable Integer id) {
        return this.partidaService.findEventosByPartidaId(id);
    }
}
