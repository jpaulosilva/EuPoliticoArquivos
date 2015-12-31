package br.com.euPoliticoBD;

/**
 * 
 * @author Jo�o Paulo
 * Classe respons�vel por armazenar os resultados da consulta ao BD de pautas
 */
public class PautaResultado {
	
	private String id;
	
	private String assunto;
	
	private String data; 
	
	private String horario;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	

}
