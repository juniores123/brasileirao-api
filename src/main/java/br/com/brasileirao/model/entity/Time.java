package br.com.brasileirao.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "tb_time")
@Getter @Setter
public class Time extends EntityBase {
	
	private String nome;
	private String pais;
	private String estado;
	
	private boolean ativo;

}
