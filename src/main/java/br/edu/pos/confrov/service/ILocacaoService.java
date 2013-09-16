package br.edu.pos.confrov.service;

import java.util.List;

import br.edu.pos.confrov.entity.Locacao;

public interface ILocacaoService {

	public List<Locacao> findByAll();

	public Locacao criaLocacao(Locacao locacao);

	public Locacao editaLocacao(Locacao object);

}
