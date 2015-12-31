package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.EstatisticasEleitorado;
import br.com.euPoliticoConexaoDAO.PMF;

/**
 * 
 * @author João Paulo
 * Servlet responsável por atualizar o BD de estatísticas do eleitorado
 * Acessível por "http://1-dot-wseupolitico.appspot.com/atualizadorBDEstatisticasEleitorado"
 */
public class AtualizadorBDEstatisticasEleitorado extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EstatisticasEleitorado ee = new EstatisticasEleitorado();
		
		ee.setId("1");
		ee.setEstado("PE");
		ee.setCidade("Recife");
		ee.setFaixaEtariaMedia(35.5);
		ee.setQtdEleitores(1_500_000);
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(ee);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}


	}

}
