package br.com.brasileirao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasileirao.model.entity.Torneio;

public interface TorneioRepository extends JpaRepository<Torneio, Integer> {

}
