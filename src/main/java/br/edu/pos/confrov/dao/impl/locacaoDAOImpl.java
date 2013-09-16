package br.edu.pos.confrov.dao.impl;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.entity.Locacao;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.ILocacaoDAO;

public class locacaoDAOImpl implements ILocacaoDAO {

private static final long serialVersionUID = 1L;
	
	@Override
	public Locacao criaLocacao(Locacao locacao, Dba dba) {

		EntityManager em = dba.getActiveEm();  

		em.persist(locacao);  

		return locacao;  
	}  

	@SuppressWarnings("unchecked")
	@Override
	public List<Locacao> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Locacao.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Locacao editaLocacao(Locacao locacao) {

		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(locacao);
			tx.commit();
			return dba.getActiveEm().find(Locacao.class, locacao.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return locacao;  
	}

	@Override
	public Locacao findById(Long id) {
		return null;
	}


}
