package br.edu.pos.confrov.service;

import java.io.Serializable;

import br.edu.pos.confrov.entity.Veiculo;

public interface IVeiculoService extends Serializable{

	public Veiculo criaVeiculo(Veiculo veiculo);

	public Veiculo findById(Long id);
	
}
