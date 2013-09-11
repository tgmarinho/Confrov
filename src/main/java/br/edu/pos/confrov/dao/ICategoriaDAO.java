package br.edu.pos.confrov.dao;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.entity.Marca;
import br.edu.pos.confrov.persistence.Dba;

public interface ICategoriaDAO {

	public Categoria criaCategoria(Categoria categoria);

	public Marca findByDescricao(String descricao);


}
