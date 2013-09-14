package br.edu.pos.confrov.service.impl;

import java.util.List;

import br.edu.pos.confrov.dao.ICidadeDAO;
import br.edu.pos.confrov.dao.impl.CidadeDAOImpl;
import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.ICidadeService;

public class CidadeServiceImpl implements ICidadeService{
	private ICidadeDAO cidadeDAO = new CidadeDAOImpl();



	public Cidade criaCidade(Cidade cidade) {
		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			cidade = cidadeDAO.criaCidade(cidade, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return cidade;
	}

	public Cidade findByNome(String nome) {
		// open transaction  
		Dba dba = new Dba();
		Cidade	 cidade;
		try{
			cidade = cidadeDAO.findByNome(nome);
		} finally {
			dba.closeEm();
		}
		return cidade;
	}
	@Override
	public List<Cidade> findByAll() {
		
		Dba dba = new Dba();
		List<Cidade> cidades;
		try {
			cidades = cidadeDAO.findByAll();
		} finally {
			dba.closeEm();
		}
		
		return cidades;
		
	}

	@Override
	public List<Cidade> findbyEstado(Long estado) {
		// open transaction  
				Dba dba = new Dba();
				List<Cidade> cidades;
				try{
					cidades =  cidadeDAO.findbyEstado(estado);
				} finally {
					dba.closeEm();
				}
				return cidades;
	}


}
