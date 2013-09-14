package br.edu.pos.confrov.dao;

import java.util.List;

import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;

public interface IEstadoDAO {
	public Estado criaEstado(Estado estado, Dba dba);

	public Estado findByDescricao(String descricao);

	public List<Estado> findByAll();
	
	public Estado findById(int Id);


}
