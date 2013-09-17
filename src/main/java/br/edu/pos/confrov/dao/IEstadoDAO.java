package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.common.util.impl.Log;

import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;

public interface IEstadoDAO extends Serializable {
	
	public Estado criaEstado(Estado estado, Dba dba);

	public Estado findByDescricao(String nome);

	public List<Estado> findByAll();
	
	public Estado findById(Long Id);

	public Estado editaEstado(Estado estado);


}
