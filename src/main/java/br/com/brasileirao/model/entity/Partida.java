package br.com.brasileirao.model.entity;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_partida")
@Getter @Setter
public class Partida extends EntityBase {
	
	private LocalDateTime dataPartida;
	
	private String placar;
	
	@OneToOne
	private Time timeVencedor;
	
	@ManyToMany
	private Time timeUm;

	@ManyToMany
	private Time timeDois;
	
	@ManyToOne
	private Torneio torneio;

}
