package br.com.brasileirao.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_transferencia")
@Getter @Setter
public class Transferencia extends EntityBase {
	
	private LocalDateTime data;
	private BigDecimal valor;
	
	@OneToOne
	@JoinColumn(name="time_origem_id")
	private Time timeOrigem;
	
	@OneToOne
	@JoinColumn(name="jogador_destino_id")
	private Time timeDestino;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="transferencia_id")
	private List<Jogador> jogadores;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="transferencia_id")
	private List<Time> times;

	
    @PrePersist
    private void prePersist() {
    	data = LocalDateTime.now();
    }

}
