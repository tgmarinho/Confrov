package br.edu.pos.confrov.service;

import java.util.List;

import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Estado;

public interface ICidadeService {

	public Cidade criaCidade(Cidade cidade);

	public Cidade findByNome(String nome);

	public List<Cidade> findByAll();
		
	List<Cidade> findbyEstado(Long estado);

}
