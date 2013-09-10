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

	public Marca findByDescricao(Marca marca, Dba dba){

		try{
			return (Marca) dba.getActiveEm().createQuery("from Marca ma order by ma.descricao").getSingleResult();
		} finally{
			dba.closeEm();
		}


	}



}
