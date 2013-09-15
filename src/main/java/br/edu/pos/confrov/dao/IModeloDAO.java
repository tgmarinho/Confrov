package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;

public interface IModeloDAO extends Serializable {

	public Modelo criaModelo(Modelo modelo, Dba dba);

	public Modelo findByDescricao(String descricao);

	public Modelo findById(Long id);

	public Modelo editaModelo(Modelo modelo);

	public List<Modelo> findByAll();

}
