package br.edu.pos.confrov.service;

import java.util.List;

import br.edu.pos.confrov.entity.Estado;

public interface IEstadoService {
	

	public Estado criaEstado(Estado estado);

	public Estado findByDescricao(String nome);

	public List<Estado> findByAll();

}
