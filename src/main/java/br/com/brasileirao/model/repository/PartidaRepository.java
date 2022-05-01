package br.com.brasileirao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasileirao.model.entity.Partida;

import java.util.List;
import java.util.Optional;

public interface PartidaRepository extends JpaRepository<Partida, Integer>{ }
