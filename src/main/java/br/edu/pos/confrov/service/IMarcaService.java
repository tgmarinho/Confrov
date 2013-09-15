package br.edu.pos.confrov.service;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Marca;

public interface IMarcaService extends Serializable{

	public Marca criaMarca(Marca marca);
	
	public Marca findByDescricao(String descricao);

	public List<Marca> findByAll();

	public Marca editaMarca(Marca marca);
}
