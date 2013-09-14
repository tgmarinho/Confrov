package br.edu.pos.confrov.service;

import br.edu.pos.confrov.entity.Veiculo;

public interface IVeiculoService {

	public Veiculo criaModelo(Veiculo veiculo);

	public Veiculo findById(Long id);
	
}
