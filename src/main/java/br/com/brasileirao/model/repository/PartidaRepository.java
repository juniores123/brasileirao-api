package br.com.brasileirao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasileirao.model.entity.Partida;

public interface PartidaRepository extends JpaRepository<Partida, Integer>{

}
