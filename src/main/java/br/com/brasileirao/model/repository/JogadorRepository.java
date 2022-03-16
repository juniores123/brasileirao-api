package br.com.brasileirao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasileirao.model.entity.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

}
