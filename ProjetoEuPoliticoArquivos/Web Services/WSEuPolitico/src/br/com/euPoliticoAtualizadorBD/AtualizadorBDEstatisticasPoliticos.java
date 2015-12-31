package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.EstatisticasPoliticos;
import br.com.euPoliticoConexaoDAO.PMF;

/**
 * 
 * @author João Paulo
 * Servlet responsável por atualizar o BD de estatísticas dos políticos
 * Acessível por "http://1-dot-wseupolitico.appspot.com/atualizadorBDEstatisticasPoliticos"
 */
public class AtualizadorBDEstatisticasPoliticos extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EstatisticasPoliticos ep = new EstatisticasPoliticos();
		
		ep.setId("1");
		ep.setEstado("RN");
		ep.setCidade("Natal");
		ep.setCargo("Senador");
		ep.setEscolaridadeEnsinoMedio(0.75);
		ep.setFaixaEtariaMedia(55.7);
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(ep);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}

	}

}
