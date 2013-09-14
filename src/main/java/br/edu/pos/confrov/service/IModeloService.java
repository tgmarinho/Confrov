package br.edu.pos.confrov.service;

import java.io.Serializable;

import br.edu.pos.confrov.entity.Modelo;

public interface IModeloService extends Serializable{

	public Modelo criaModelo(Modelo modelo);

	public Modelo findByDescricao(String descricao);
	
	public Modelo findById(Long id);

}
