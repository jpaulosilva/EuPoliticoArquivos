package br.com.euPoliticoAtualizadorBD;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.euPoliticoBD.ApuracaoVotos;
import br.com.euPoliticoConexaoDAO.PMF;

/**
 * 
 * @author Jo�o Paulo
 * Servlet respons�vel por atualizar o BD de apura��o de votos
 * Acess�vel por "http://1-dot-wseupolitico.appspot.com/atualizadorBDApuracaoVotos"
 */
public class AtualizadorBDApuracaoVotos extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ApuracaoVotos av = new ApuracaoVotos();
		
		av.setId("1");
		av.setEstado("SP");
		av.setCidade("Santos");
		av.setCargo("Senador");
		av.setNumeroCandidato(22);
		av.setNumeroVotos(110500);
		av.setPorcentagemVotos(0.30);
		av.setCandidato("Marcos de Oliveira");
		
		
		PersistenceManager pm = PMF.get().getPersistenceManager();

		try {
			pm.makePersistent(av);
			response.getWriter().write("Banco atualizado com sucesso!!");
		} finally {
			pm.close();
		}

	}

}
