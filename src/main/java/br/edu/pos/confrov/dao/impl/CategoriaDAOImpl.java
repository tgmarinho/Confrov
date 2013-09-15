package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.ICategoriaDAO;
import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.persistence.Dba;

public class CategoriaDAOImpl implements ICategoriaDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public Categoria criaCategoria(Categoria categoria, Dba dba) {
		EntityManager em = dba.getActiveEm();  

		em.persist(categoria);  

		return categoria;  
	}

	@Override
	public Categoria editaCategoria(Categoria categoria) {

		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(categoria);
			tx.commit();
			return dba.getActiveEm().find(Categoria.class, categoria.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return categoria;  
	}

	@Override
	public Categoria findByDescricao(String descricao) {

		Dba dba = new Dba(true);

		try{
			return (Categoria) dba.getActiveEm().createNamedQuery("Categoria.findByDescricao").setParameter("descricao", descricao).getSingleResult(); 
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
	public List<Categoria> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Categoria.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

}
