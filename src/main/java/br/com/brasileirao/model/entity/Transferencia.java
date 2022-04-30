package br.com.brasileirao.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_transferencia")
@Getter @Setter
public class Transferencia extends EntityBase {
	
	private LocalDateTime data;
	private BigDecimal valor;
	
	@ManyToOne
	private Time timeOrigem;
	
	@ManyToOne
	private Time timeDestino;
	
	@ManyToOne
	private Jogador jogador;
	
    @PrePersist
    private void prePersist() {
    	data = LocalDateTime.now();
    }

}
