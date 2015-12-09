package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.Pauta;
import br.com.euPoliticoConexaoDAO.PMF;

public class AtualizadorBDPauta extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Pauta pauta = new Pauta();
		
		pauta.setId("1");
		pauta.setAssunto("Reforma Política");
		pauta.setData("03/12/2015");
		pauta.setHorario("14h");

		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(pauta);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}
	}

}
