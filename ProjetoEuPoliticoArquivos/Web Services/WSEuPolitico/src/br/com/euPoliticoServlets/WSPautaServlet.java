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

public class WSPautaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Controller controlador = new Controller();
		
		List<PautaResultado> pautaResultado = controlador.getPauta();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(pautaResultado);

		ServletUtil.writeJSON(response, json);

	}

}
