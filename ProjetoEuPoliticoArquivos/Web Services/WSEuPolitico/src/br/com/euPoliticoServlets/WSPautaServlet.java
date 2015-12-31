package br.com.euPoliticoServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.euPoliticoBD.PautaResultado;
import br.com.euPoliticoControlador.Controller;

/**
 * 
 * @author João Paulo
 * Servlet responsável por acessar o serviço de Pautas
 */
public class WSPautaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Controller controlador = new Controller();
		
		//Chama o método do controlador, retornando um List com os resultados de todas as pautas
		List<PautaResultado> pautaResultado = controlador.getPauta();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//Transforma a lista de resultados em formato JSON
		String json = gson.toJson(pautaResultado);
		
		//Escreve na resposta do serviço o JSON
		ServletUtil.writeJSON(response, json);

	}

}
