package br.edu.pos.confrov.service.impl;

import br.edu.pos.confrov.dao.IVeiculoDAO;
import br.edu.pos.confrov.dao.impl.VeiculoDAOImpl;
import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.IVeiculoService;

public class VeiculoServiceImpl implements IVeiculoService {

	IVeiculoDAO veiculoDAO = new VeiculoDAOImpl();

	@Override
	public Veiculo criaModelo(Veiculo veiculo) {
		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			veiculo = veiculoDAO.criaModelo(veiculo, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return veiculo;
	}

	@Override
	public Veiculo findById(Long id) {
		Dba dba = new Dba();
		Veiculo veiculo;
		try{
			veiculo = veiculoDAO.findById(id);
		} finally {
			dba.closeEm();
		}
		return veiculo;
	}

}
