package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.IModeloDAO;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;

public class ModeloDAOImpl implements IModeloDAO {

	private static final long serialVersionUID = 1L;
	
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
		}catch (Exception c){
			c.printStackTrace();
		}
		finally{
			dba.closeEm();
		}
		return null;

	}

	@Override
	public Modelo findById(Long id) {
		Dba dba = new Dba(true);

		try{
			return (Modelo) dba.getActiveEm().createNamedQuery("Modelo.findById").setParameter("id", id).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Modelo> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Modelo.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Modelo editaModelo(Modelo modelo) {

		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(modelo);
			tx.commit();
			return dba.getActiveEm().find(Modelo.class, modelo.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return modelo;  
	}

}
