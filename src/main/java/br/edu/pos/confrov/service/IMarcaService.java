package br.edu.pos.confrov.service;

import java.io.Serializable;

import br.edu.pos.confrov.entity.Marca;

public interface IMarcaService extends Serializable{

	public Marca criaMarca(Marca marca);
	
	public Marca findByDescricao(String descricao);
}
