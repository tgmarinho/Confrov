package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.ICidadeDAO;
import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.persistence.Dba;

public class CidadeDAOImpl implements ICidadeDAO {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Cidade criaCidade(Cidade cidade, Dba dba) {
		EntityManager em = dba.getActiveEm();  

		em.persist(cidade);  

		return cidade;  
	}

	@Override
	public Cidade findByNome(String nome) {
		Dba dba = new Dba(true);

		try{
			return (Cidade) dba.getActiveEm().createNamedQuery("Cidade.findByNome").setParameter("nome", nome).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cidade> findbyEstado(Long estado) {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Cidade.findByEstado").setParameter("estado", estado).getResultList();
		} finally{
			dba.closeEm();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Cidade.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Cidade editaCidade(Cidade cidade) {
		// TODO Auto-generated method stub
		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(cidade);
			tx.commit();
			return dba.getActiveEm().find(Cidade.class, cidade.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return cidade;  
	}

	@Override
	public Cidade findById(Long id) {
		Dba dba = new Dba(true);

		try{
			return (Cidade) dba.getActiveEm().createNamedQuery("Cidade.findById").setParameter("id", id).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Cidade Remove(Cidade cidade, Dba dba) {
		EntityManager em = dba.getActiveEm();  

		em.remove(cidade);  

		return cidade;  
	}

}
