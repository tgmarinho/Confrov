package br.edu.pos.confrov.service.impl;

import java.util.List;

import br.edu.pos.confrov.dao.IEstadoDAO;
import br.edu.pos.confrov.dao.impl.EstadoDAOImpl;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.IEstadoService;

public class EstadoServiceImpl implements IEstadoService {

	private static final long serialVersionUID = 1L;
	
	IEstadoDAO estadoDAO = new EstadoDAOImpl();
	
	@Override
	public Estado criaEstado(Estado estado) {
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			estado = estadoDAO.criaEstado(estado, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return estado;
	}

	@Override
	public Estado findByDescricao(String nome) {
		Dba dba = new Dba(); // DBA abra e fecha e faz outroas coisas de conexao com o banco de dados
		Estado estado;
		try{
			estado = estadoDAO.findByDescricao(nome);
		} finally {
			dba.closeEm();
		}
		return estado;
	}

	@Override
	public List<Estado> findByAll() {
		Dba dba = new Dba();
		List<Estado> estados;
		try {
			estados = estadoDAO.findByAll();
		} finally {
			dba.closeEm();
		}
		
		return estados;

	}
	
	public Estado findById (Long Id){
		Dba dba = new Dba(true);
		try{
			return (Estado) dba.getActiveEm().createNamedQuery("Estado.findById").setParameter("Id", Id).getSingleResult();
		}finally{
			dba.closeEm();
		}
	}

	@Override
	public Estado editaEstado(Estado Estado) {
		return Estado = estadoDAO.editaEstado(Estado);
	}

}
