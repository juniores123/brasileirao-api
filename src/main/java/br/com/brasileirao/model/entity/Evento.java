package br.com.brasileirao.model.entity;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;

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
