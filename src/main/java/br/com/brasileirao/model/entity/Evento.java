package br.com.brasileirao.model.entity;

import br.com.brasileirao.model.entity.base.EntityBase;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name="tb_evento")
@Getter
@Setter
public class Evento extends EntityBase {
    private String name;
}
