package br.com.brasileirao.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tb_evento")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Evento extends EntityBase {
    private String name;

    @ManyToOne
    private Jogador jogador;

    @ManyToOne
    private Time time;

    @ManyToOne
    private Partida partida;

    private String jogadorNameEntra;
}
