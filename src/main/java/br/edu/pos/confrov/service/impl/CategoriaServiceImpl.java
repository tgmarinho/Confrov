package br.edu.pos.confrov.service.impl;

import br.edu.pos.confrov.dao.ICategoriaDAO;
import br.edu.pos.confrov.dao.impl.CategoriaDAOImpl;
import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.ICategoriaService;

public class CategoriaServiceImpl implements ICategoriaService {

	
	ICategoriaDAO categoriaDAO = new CategoriaDAOImpl();
	
	@Override
	public Categoria criaCategoria(Categoria categoria) {

		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			categoria = categoriaDAO.criaCategoria(categoria, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return categoria;
	}

	@Override
	public Categoria findByDescricao(String descricao) {

		Dba dba = new Dba();
		Categoria categoria;
		try{
			categoria = categoriaDAO.findByDescricao(descricao);
		} finally {
			dba.closeEm();
		}
		return categoria;
	}

}
