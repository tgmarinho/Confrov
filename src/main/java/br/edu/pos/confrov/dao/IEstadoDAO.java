package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;

public interface IEstadoDAO extends Serializable {
	public Estado criaEstado(Estado estado, Dba dba);

	public Estado findByDescricao(String descricao);

	public List<Estado> findByAll();
	
	public Estado findById(int Id);

	public Estado editaEstado(Estado Estado);


}
