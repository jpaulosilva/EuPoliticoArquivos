package br.com.euPoliticoServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.euPoliticoBD.PesquisaEleitoralResultado;
import br.com.euPoliticoControlador.Controller;

/**
 * 
 * @author Jo�o Paulo
 * Servlet respons�vel por acessar o servi�o de Pesquisa Eleitoral
 */
public class WSPesquisaEleitoralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Controller controlador = new Controller();
		
		//Chama o m�todo do controlador, retornando um List com os resultados das pesquisas eleitorais
		List<PesquisaEleitoralResultado> pesquisaTotal = controlador.getPesquisaEleitoral();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		//Transforma a lista de resultados em formato JSON
		String json = gson.toJson(pesquisaTotal);
		
		//Escreve na resposta do servi�o o JSON
		ServletUtil.writeJSON(response, json);
	}
}
