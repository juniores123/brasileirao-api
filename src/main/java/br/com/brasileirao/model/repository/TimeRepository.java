package br.com.brasileirao.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasileirao.model.entity.Time;

public interface TimeRepository extends JpaRepository<Time, Integer> {

}
