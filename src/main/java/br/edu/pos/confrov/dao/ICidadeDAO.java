package br.edu.pos.confrov.dao;

import java.util.List;

import br.edu.pos.confrov.entity.Cidade;
import br.edu.pos.confrov.entity.Estado;
import br.edu.pos.confrov.persistence.Dba;

public interface ICidadeDAO {
	
	public Cidade criaCidade(Cidade cidade, Dba dba);

	public Cidade findByNome(String nome);
	
	public List<Cidade> findbyEstado (int estado);
	
	public List<Cidade> findByAll();



}
