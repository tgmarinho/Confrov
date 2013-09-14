package br.edu.pos.confrov.service;

import br.edu.pos.confrov.entity.Modelo;

public interface IModeloService {

	public Modelo criaModelo(Modelo modelo);

	public Modelo findByDescricao(String descricao);
	
	public Modelo findById(Long id);

}
