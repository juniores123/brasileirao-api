package br.com.brasileirao.model.entity;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_partida")
@Getter @Setter
public class Partida extends EntityBase {
	
	private LocalDateTime dataPartida;

	@ManyToOne
	private Time vencedor;

	@ManyToOne
	private Time timeUm;

	@ManyToOne
	private Time timeDois;
	
	@ManyToOne
	private Torneio torneio;
}
