package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.persistence.Dba;

public interface IVeiculoDAO extends Serializable {

	public Veiculo criaModelo(Veiculo veiculo, Dba dba);

	public Veiculo findById(Long id);

	public List<Veiculo> findByAll();
	
	public Veiculo editaVeiculo(Veiculo veiculo);
	
	
}
