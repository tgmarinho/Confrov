package br.edu.pos.confrov.service.impl;

import java.util.List;

import br.edu.pos.confrov.dao.impl.locacaoDAOImpl;
import br.edu.pos.confrov.entity.Locacao;
import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.service.ILocacaoDAO;
import br.edu.pos.confrov.service.ILocacaoService;

public class LocacaoServiceImpl implements ILocacaoService {


	ILocacaoDAO locacaoDAO = new locacaoDAOImpl();

	@Override
	public Locacao criaLocacao(Locacao locacao) {
		// open transaction  
		Dba dba = new Dba();
		try{
			// createUser 'adopts' the transaction
			locacao = locacaoDAO.criaLocacao(locacao, dba);
		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}
		return locacao;
	}

	
	@Override
	public List<Locacao> findByAll() {
		Dba dba = new Dba();
		List<Locacao> locacaos;
		try {
			locacaos = locacaoDAO.findByAll();
		} finally {
			dba.closeEm();
		}

		return locacaos;
	}


	public Locacao editaLocacao(Locacao Locacao) {
		return Locacao = locacaoDAO.editaLocacao(Locacao);
	}


}
