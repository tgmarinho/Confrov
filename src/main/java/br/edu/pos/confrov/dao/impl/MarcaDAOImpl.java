package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.IMarcaDAO;
import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public class MarcaDAOImpl implements IMarcaDAO {

	private static final long serialVersionUID = 1L;
	
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
		}catch (Exception c){
			c.printStackTrace();
		}
		finally{
			dba.closeEm();
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Marca> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Marca.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Marca editaMarca(Marca marca) {

		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(marca);
			tx.commit();
			return dba.getActiveEm().find(Marca.class, marca.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return marca;  
	}

}
