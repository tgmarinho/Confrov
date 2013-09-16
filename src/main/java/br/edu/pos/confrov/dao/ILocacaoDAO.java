package br.edu.pos.confrov.dao;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Locacao;

public interface ILocacaoDAO  extends Serializable{

	public Locacao criaLocacao(Locacao locacao);

	public Locacao findById(Long id);

	public List<Locacao> findByAll();

	public Locacao editaLocacao(Locacao locacao);
	
}
