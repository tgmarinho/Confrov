package br.edu.pos.confrov.dao.impl;

import br.edu.pos.confrov.dao.IModeloService;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;

public class ModeloServiceImpl implements IModeloService {

//	private IModeloDAO modeloDAO = new ModeloServiceImpl();

	@Override
	public Modelo criaModelo(Modelo modelo) {
		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
//			modelo = modeloDAO.criaModelo(modelo, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return modelo;
	}

	@Override
	public Modelo findByDescricao(Modelo modelo) {
		// TODO Auto-generated method stub
		return null;
	}

}
