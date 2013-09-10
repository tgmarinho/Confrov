package br.edu.pos.confrov.service;

import br.edu.pos.confrov.entity.Marca;

public interface IMarcaService {

	public Marca criaMarca(Marca marca);
	
	public Marca findByDescricao(Marca marca);
}
