package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.pos.confrov.dao.IEstadoDAO;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;

public class EstadoDAOImpl implements IEstadoDAO {

	@Override
	public Estado criaEstado(Estado estado, Dba dba) {
		EntityManager em = dba.getActiveEm();  

		em.persist(estado);  

		return estado;
	}

	@Override
	public Estado findByDescricao(String nome) {
		Dba dba = new Dba(true);

		try{
			return (Estado) dba.getActiveEm().createNamedQuery("Estado.findByDescricao").setParameter("nome", nome).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public List<Estado> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Estado.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

}
