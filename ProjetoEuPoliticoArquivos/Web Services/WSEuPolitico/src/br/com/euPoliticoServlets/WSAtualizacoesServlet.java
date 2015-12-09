package br.com.euPoliticoServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.euPoliticoBD.AtualizacoesResultado;
import br.com.euPoliticoControlador.Controller;

public class WSAtualizacoesServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Controller controlador = new Controller();
		
		List<AtualizacoesResultado> atualResultado = controlador.getAtualizacoes();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(atualResultado);

		ServletUtil.writeJSON(response, json);

	}

}
