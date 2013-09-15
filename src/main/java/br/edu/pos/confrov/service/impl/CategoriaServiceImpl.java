package br.edu.pos.confrov.service.impl;

import java.util.List;

import br.edu.pos.confrov.dao.ICategoriaDAO;
import br.edu.pos.confrov.dao.impl.CategoriaDAOImpl;
import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.ICategoriaService;

public class CategoriaServiceImpl implements ICategoriaService {


	private static final long serialVersionUID = 1L;

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

		Dba dba = new Dba(); // DBA abra e fecha e faz outroas coisas de conexao com o banco de dados
		Categoria categoria;
		categoria = categoriaDAO.findByDescricao(descricao);
		return categoria;
	}

	@Override
	public List<Categoria> findByAll() {

		Dba dba = new Dba();
		List<Categoria> categorias;
		try {
			categorias = categoriaDAO.findByAll();
		} finally {
			dba.closeEm();
		}

		return categorias;

	}

}
