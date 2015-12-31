package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.PesquisaEleitoral;
import br.com.euPoliticoConexaoDAO.PMF;

/**
 * 
 * @author João Paulo
 * Servlet responsável por atualizar o BD de pesquisas eleitorais
 * Acessível por "http://1-dot-wseupolitico.appspot.com/atualizadorBDPesquisaEleitoral"
 */
public class AtualizadorBDPesquisaEleitoral extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PesquisaEleitoral pe = new PesquisaEleitoral();

		pe.setId("1");
		pe.setEstado("Pernambuco");
		pe.setCidade("Camaragibe");
		pe.setCargo("Deputado");
		pe.setNumeroCandidato("50");
		pe.setNomeCandidato("José de Abreu");
		pe.setQtdVotos("72340");
		pe.setInstitutoPesquisa("IBOPE");

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(pe);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}
	}

}
