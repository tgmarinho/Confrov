package br.edu.pos.confrov.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.edu.pos.confrov.dao.IClienteDAO;
import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Cliente;
import br.edu.pos.confrov.persistence.Dba;

public class ClienteDAOImpl implements IClienteDAO {

	@Override
	public Cliente criaCliente(Cliente cliente, Dba dba) {
		EntityManager em = dba.getActiveEm();  

		em.persist(cliente);  

		return cliente;  
	}

	@Override
	public Cliente findByNome(String nome) {
		Dba dba = new Dba(true);

		try{
			return (Cliente) dba.getActiveEm().createNamedQuery("Cliente.findByNome").setParameter("nome", nome).getSingleResult();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public List<Cliente> findbyCPF(Long cpf) {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Cliente.findByCPF").setParameter("cpf", cpf).getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public List<Cliente> findByAll() {
		Dba dba = new Dba(true);

		try{
			return dba.getActiveEm().createNamedQuery("Cliente.findAll").getResultList();
		} finally{
			dba.closeEm();
		}
	}

	@Override
	public Cliente editaCliente(Cliente cliente) {
		Dba dba = new Dba();
		try{
			EntityTransaction tx =  dba.getActiveEm().getTransaction();
			if(!tx.isActive()){
				tx.begin();
			}
			dba.getActiveEm().merge(cliente);
			tx.commit();
			return dba.getActiveEm().find(Cliente.class, cliente.getId());
			
		} catch (Exception e ){
			e.printStackTrace();
		} finally {
			dba.getActiveEm().close();
		}
		return cliente;  
	}
	

}
