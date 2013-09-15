package br.edu.pos.confrov.service.impl;

import java.util.List;

import br.edu.pos.confrov.dao.IMarcaDAO;
import br.edu.pos.confrov.dao.impl.MarcaDAOImpl;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.IMarcaService;

public class MarcaServiceImpl implements IMarcaService {

	private static final long serialVersionUID = 1L;
	
	IMarcaDAO marcaDAO = new MarcaDAOImpl();

	@Override
	public Marca criaMarca(Marca marca) {

		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			marca = marcaDAO.criaMarca(marca, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return marca;

	}


	public Marca findByDescricao(String descricao){
		// open transaction  
		Dba dba = new Dba();
		Marca marca;
		try{
			marca = marcaDAO.findByDescricao(descricao);
		} finally {
			dba.closeEm();
		}
		return marca;

	}


	@Override
	public List<Marca> findByAll() {
		Dba dba = new Dba();
		List<Marca> marcas;
		try {
			marcas = marcaDAO.findByAll();
		} finally {
			dba.closeEm();
		}

		return marcas;
	}


	@Override
	public Marca editaMarca(Marca marca) {
		return marca = marcaDAO.editaMarca(marca);
	}

}
