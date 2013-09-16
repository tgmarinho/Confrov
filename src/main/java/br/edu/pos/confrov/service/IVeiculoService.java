package br.edu.pos.confrov.service;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Veiculo;

public interface IVeiculoService extends Serializable{

	public Veiculo criaVeiculo(Veiculo veiculo);

	public Veiculo findById(Long id);

	public List<Veiculo> findByAll();

	public Veiculo editaVeiculo(Veiculo veiculo);
	
}
