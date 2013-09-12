package br.edu.pos.confrov.dao.impl;

import javax.persistence.EntityManager;

import br.edu.pos.confrov.dao.ICategoriaDAO;
import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public class CategoriaDAOImpl implements ICategoriaDAO {

	@Override
	public Categoria criaCategoria(Categoria categoria, Dba dba) {
		EntityManager em = dba.getActiveEm();  

		em.persist(categoria);  

		return categoria;  
	}

	@Override
	public Categoria findByDescricao(String descricao) {
	
		Dba dba = new Dba(true);

		try{
			return (Categoria) dba.getActiveEm().createNamedQuery("Categoria.findByDescricao").setParameter("descricao", descricao).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}

}
