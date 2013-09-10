package br.edu.pos.confrov.dao;

import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public interface IMarcaDAO {

	public Marca criaMarca(Marca marca, Dba dba);
	
	public Marca findByDescricao(String descricao);
	
}
