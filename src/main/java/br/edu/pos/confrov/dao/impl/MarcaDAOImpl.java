package br.edu.pos.confrov.dao.impl;

import javax.persistence.EntityManager;

import br.edu.pos.confrov.dao.IMarcaDAO;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public class MarcaDAOImpl implements IMarcaDAO {

	@Override
	public Marca criaMarca(Marca marca, Dba dba) {

		EntityManager em = dba.getActiveEm();  

		em.persist(marca);  

		return marca;  
	}  

	public Marca findByDescricao(String descricao){

		Dba dba = new Dba(true);

		try{
			return (Marca) dba.getActiveEm().createNamedQuery("Marca.findByDescricao").setParameter("descricao", descricao).getSingleResult();
		} finally{
			dba.closeEm();
		}

	}

}
