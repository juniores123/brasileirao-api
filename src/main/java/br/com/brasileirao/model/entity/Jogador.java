package br.com.brasileirao.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
    private String endereço;
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="jogador_id")
	private List<Time> times;
  
    
    private boolean ativo;
    
    
    @PrePersist
    private void prePersist() {
        ativo = true;
    }

}
