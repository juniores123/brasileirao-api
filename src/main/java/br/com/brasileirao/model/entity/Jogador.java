package br.com.brasileirao.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "tb_jogador")
@Getter @Setter
public class Jogador extends EntityBase {
	
	private String nome;
	private LocalDateTime dataNascimento;
	private String cpf;
    private String email;
    private String pais;
    private String endereco;
    
    @OneToOne
	private Time time;
  
    
    private boolean ativo;
}

