package br.edu.pos.confrov.servlet;

import javax.servlet.http.HttpServlet;

import br.edu.pos.confrov.persistence.Dba;
import br.edu.pos.confrov.persistence.PersistenceFactory;

/**
 * Servlet implementation class InitContext
 */
public class InitContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitContext() {
//		PersistenceFactory.getEntityManager();
		Dba dba = new Dba(false);
	}
}
