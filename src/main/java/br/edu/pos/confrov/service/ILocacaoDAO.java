package br.edu.pos.confrov.service;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Locacao;
import br.edu.pos.confrov.persistence.Dba;

public interface ILocacaoDAO  extends Serializable{

	public Locacao criaLocacao(Locacao locacao, Dba dba);

	public Locacao findById(Long id);

	public List<Locacao> findByAll();

	public Locacao editaLocacao(Locacao locacao);
	
}
