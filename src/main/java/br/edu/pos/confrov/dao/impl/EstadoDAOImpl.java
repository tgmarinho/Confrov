package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.IEstadoDAO;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;

public class EstadoDAOImpl implements IEstadoDAO {

	private static final long serialVersionUID = 1L;
	
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
	public Estado editaEstado (Estado Estado) {

		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(Estado);
			tx.commit();
			return dba.getActiveEm().find(Estado.class, Estado.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return Estado;  
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Estado.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}
	
	public Estado findById (int Id){
		Dba dba = new Dba(true);
		try{
			return (Estado) dba.getActiveEm().createNamedQuery("Estado.findById").setParameter("Id", Id).getSingleResult();
		}finally{
			dba.closeEm();
		}
	}

}
