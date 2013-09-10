package br.edu.pos.confrov.dao.impl;

import javax.persistence.EntityManager;

import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;

public class ModeloDAOImpl implements IModeloDAO {

	@Override
	public Modelo criaModelo(Modelo modelo, Dba dba) {

		EntityManager em = dba.getActiveEm();  

		em.persist(modelo);  

		return modelo;  
	}  

	public Modelo findByDescricao(String descricao){

		Dba dba = new Dba(true);

		try{
			return (Modelo) dba.getActiveEm().createNamedQuery("Modelo.findByDescricao").setParameter("descricao", descricao).getSingleResult();
		} finally{
			dba.closeEm();
		}

	}

}
