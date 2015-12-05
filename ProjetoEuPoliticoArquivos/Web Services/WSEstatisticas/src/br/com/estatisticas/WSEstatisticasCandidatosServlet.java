package br.com.estatisticas;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.BDEstatisticas.EstatisticasCandidatosResultado;
import br.com.estatisticasContoller.EstatisticasController;

public class WSEstatisticasCandidatosServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EstatisticasController controlador = new EstatisticasController();
		
		List<EstatisticasCandidatosResultado> estatisticasCandidatos = controlador.getEstatisticasCandidatos();
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(estatisticasCandidatos);

		ServletUtil.writeJSON(response, json);

	}

}
