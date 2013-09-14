package br.edu.pos.confrov.dao;

import java.io.Serializable;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public interface IMarcaDAO extends Serializable {

	public Marca criaMarca(Marca marca, Dba dba);
	
	public Marca findByDescricao(String descricao);
	
}
