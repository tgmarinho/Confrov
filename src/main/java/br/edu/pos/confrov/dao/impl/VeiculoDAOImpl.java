package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.IVeiculoDAO;
import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.persistence.Dba;

public class VeiculoDAOImpl implements IVeiculoDAO {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Veiculo criaVeiculo(Veiculo veiculo, Dba dba) {

		EntityManager em = dba.getActiveEm();  

		em.persist(veiculo);  

		return veiculo;  
	}  

	@Override
	public Veiculo findById(Long id) {
		Dba dba = new Dba(true);

		try{
			return (Veiculo) dba.getActiveEm().createNamedQuery("Veiculo.findById").setParameter("id", id).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Veiculo.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Veiculo editaVeiculo(Veiculo veiculo) {

		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(veiculo);
			tx.commit();
			return dba.getActiveEm().find(Veiculo.class, veiculo.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return veiculo;  
	}
}
