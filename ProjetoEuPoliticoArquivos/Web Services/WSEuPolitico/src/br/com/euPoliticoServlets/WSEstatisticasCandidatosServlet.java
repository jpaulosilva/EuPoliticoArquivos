package br.com.euPoliticoServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.euPoliticoBD.EstatisticasCandidatosResultado;
import br.com.euPoliticoControlador.Controller;

/**
 * 
 * @author João Paulo
 * Servlet responsável por acessar o serviço de Estatísticas dos Cancidatos
 */
public class WSEstatisticasCandidatosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Controller controlador = new Controller();
		
		//Chama o método do controlador, retornando um List com os resultados
		List<EstatisticasCandidatosResultado> estatisticasCandidatos = controlador.getEstatisticasCandidatos();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//Transforma a lista de resultados em formato JSON
		String json = gson.toJson(estatisticasCandidatos);
		
		//Escreve na resposta do serviço o JSON 
		ServletUtil.writeJSON(response, json);

	}

}
