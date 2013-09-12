package br.edu.pos.confrov.service;

import br.edu.pos.confrov.entity.Categoria;

public interface ICategoriaService {

	public Categoria criaCategoria(Categoria categoria);

	public Categoria findByDescricao(String descricao);


}
