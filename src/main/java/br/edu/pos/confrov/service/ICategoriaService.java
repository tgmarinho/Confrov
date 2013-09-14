package br.edu.pos.confrov.service;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Default;

import br.edu.pos.confrov.entity.Categoria;

@Default
public interface ICategoriaService extends Serializable {

	public Categoria criaCategoria(Categoria categoria);

	public Categoria findByDescricao(String descricao);

	public List<Categoria> findByAll();


}
