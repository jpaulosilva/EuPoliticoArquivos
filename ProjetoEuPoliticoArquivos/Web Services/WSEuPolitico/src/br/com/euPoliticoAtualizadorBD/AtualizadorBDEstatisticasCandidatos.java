package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.EstatisticasCandidatos;
import br.com.euPoliticoConexaoDAO.PMF;

public class AtualizadorBDEstatisticasCandidatos extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EstatisticasCandidatos ec = new EstatisticasCandidatos();
		
		ec.setId("1");
		ec.setEstado("PE");
		ec.setCidade("Recife");
		ec.setPartido("PMDB");
		ec.setCargo("Deputado");
		ec.setTotalBens(1200000.00);
		ec.setTotalDoacoes(500000);
		ec.setGastosCampanha(1000000);
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(ec);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}

	}

}