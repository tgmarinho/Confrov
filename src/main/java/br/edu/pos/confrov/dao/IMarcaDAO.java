package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public interface IMarcaDAO extends Serializable {

	public Marca criaMarca(Marca marca, Dba dba);
	
	public Marca findByDescricao(String descricao);

	public List<Marca> findByAll();

	public Marca editaMarca(Marca marca);
	
}
