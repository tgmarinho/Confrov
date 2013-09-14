package br.edu.pos.confrov.dao.impl;

import javax.persistence.EntityManager;

import br.edu.pos.confrov.dao.IVeiculoDAO;
import br.edu.pos.confrov.entity.Veiculo;
import br.edu.pos.confrov.persistence.Dba;

public class VeiculoDAOImpl implements IVeiculoDAO {

	private static final long serialVersionUID = 1L;
	
	@Override
	public Veiculo criaModelo(Veiculo veiculo, Dba dba) {

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
}
