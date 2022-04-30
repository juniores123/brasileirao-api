package br.com.brasileirao.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "tb_torneio")
@Getter @Setter
public class Torneio extends EntityBase {
	
	private String nome;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private BigDecimal premiacao;
	
}
