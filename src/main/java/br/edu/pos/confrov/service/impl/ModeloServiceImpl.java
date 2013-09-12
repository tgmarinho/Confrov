package br.edu.pos.confrov.service.impl;

import br.edu.pos.confrov.dao.IModeloDAO;
import br.edu.pos.confrov.dao.impl.ModeloDAOImpl;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.IModeloService;

public class ModeloServiceImpl implements IModeloService {

	private IModeloDAO modeloDAO = new ModeloDAOImpl();



	@Override
	public Modelo criaModelo(Modelo modelo) {
		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			modelo = modeloDAO.criaModelo(modelo, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return modelo;
	}

	@Override
	public Modelo findByDescricao(String descricao) {
		// open transaction  
		Dba dba = new Dba();
		Modelo modelo;
		try{
			modelo = modeloDAO.findByDescricao(descricao);
		} finally {
			dba.closeEm();
		}
		return modelo;
	}

}
