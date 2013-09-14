package br.edu.pos.confrov.service;

import java.io.Serializable;
import java.util.List;

import br.edu.pos.confrov.entity.Estado;

public interface IEstadoService extends Serializable{
	

	public Estado criaEstado(Estado estado);

	public Estado findByDescricao(String nome);

	public List<Estado> findByAll();
	
	public Estado findById(int Id);

}
