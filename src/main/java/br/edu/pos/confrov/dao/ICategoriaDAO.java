package br.edu.pos.confrov.dao;

import java.util.List;

import br.edu.pos.confrov.entity.Categoria;
import br.edu.pos.confrov.persistence.Dba;

public interface ICategoriaDAO {

	public Categoria criaCategoria(Categoria categoria, Dba dba);

	public Categoria findByDescricao(String descricao);

	public List<Categoria> findByAll();

}
