package br.com.brasileirao.model.repository;

import br.com.brasileirao.model.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventoRepository extends JpaRepository<Evento, Integer> {
    Optional<Evento> findByName(String name);
}
