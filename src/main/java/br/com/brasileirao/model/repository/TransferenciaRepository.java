package br.com.brasileirao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasileirao.model.entity.Transferencia;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Integer> {

}
