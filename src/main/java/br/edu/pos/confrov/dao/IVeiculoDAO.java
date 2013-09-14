package br.edu.pos.confrov.dao;

import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.persistence.Dba;

public interface IVeiculoDAO {

	public Veiculo criaModelo(Veiculo veiculo, Dba dba);

	public Veiculo findById(Long id);
	
	
}
