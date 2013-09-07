package br.edu.pos.confrov.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="tb_marca")
@Table
public class Marca {

	@Id
	@GeneratedValue()
	private Long id;
	
	private String descricao;
	
}
