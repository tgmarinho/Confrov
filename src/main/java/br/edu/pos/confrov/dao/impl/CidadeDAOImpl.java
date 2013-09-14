package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.pos.confrov.dao.ICidadeDAO;
import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.entity.Modelo;
import br.edu.pos.confrov.persistence.Dba;

public class CidadeDAOImpl  implements ICidadeDAO {

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
	
	public List<Cidade> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Cidade.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

}
