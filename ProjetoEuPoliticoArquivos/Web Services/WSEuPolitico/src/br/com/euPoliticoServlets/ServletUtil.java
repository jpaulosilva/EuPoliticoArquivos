package br.com.euPoliticoServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Jo�o Paulo
 * Classe que cont�m o m�todo para colocar na resposta do servi�o o JSON formatado de acordo com o charset UTF-8
 */
public class ServletUtil {
	
public static void writeJSON(HttpServletResponse response, String json) throws IOException {
		
		if(json != null){
			PrintWriter writer = response.getWriter();
			response.setContentType("application/json;charset-UTF-8");
			writer.write(json);
			writer.close();
		}
	}

}
