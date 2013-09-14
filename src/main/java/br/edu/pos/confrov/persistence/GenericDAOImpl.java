package br.edu.pos.confrov.persistence;

import java.util.List;

public class GenericDAOImpl<T> extends GenericDAO<T> {

	public GenericDAOImpl(Class<T> entityClass) {
		super(entityClass);
	}

	private static final long serialVersionUID = 1L;

	@Override
	public T find(Long entityID) {
		// TODO Auto-generated method stub
		return super.find(entityID);
	}
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
	
	
}
