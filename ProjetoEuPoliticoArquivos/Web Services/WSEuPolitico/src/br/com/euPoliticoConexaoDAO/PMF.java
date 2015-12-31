package br.com.euPoliticoConexaoDAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 * 
 * @author Jo�o Paulo
 * Classe respons�vel por abrir conex�o ao BD
 */
public class PMF {
	
	private static final PersistenceManagerFactory pmfInstance = JDOHelper
			.getPersistenceManagerFactory("transactions-optional");

	private PMF() {
	}

	public static PersistenceManagerFactory get() {
		return pmfInstance;
	}

}
