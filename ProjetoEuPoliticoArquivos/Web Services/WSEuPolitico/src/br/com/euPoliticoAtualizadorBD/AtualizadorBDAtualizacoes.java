package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.Atualizacoes;
import br.com.euPoliticoConexaoDAO.PMF;

public class AtualizadorBDAtualizacoes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		Atualizacoes atual = new Atualizacoes();
		
		atual.setId("1");
		atual.setEstado("PE");
		atual.setCidade("Olinda");
		atual.setPoliticoAcompanhado("Francisco de Almeida");
		atual.setCargo("Deputado Federal");
		atual.setNovidades("############");
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(atual);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}

	}

}
