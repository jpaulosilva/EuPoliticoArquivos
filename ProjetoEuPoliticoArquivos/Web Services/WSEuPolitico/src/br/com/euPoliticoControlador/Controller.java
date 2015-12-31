package br.com.euPoliticoControlador;

import java.util.List;

import br.com.euPoliticoBD.ApuracaoVotosResultado;
import br.com.euPoliticoBD.AtualizacoesResultado;
import br.com.euPoliticoBD.EstatisticasCandidatosResultado;
import br.com.euPoliticoBD.EstatisticasEleitoradoResultado;
import br.com.euPoliticoBD.EstatisticasPoliticosResultado;
import br.com.euPoliticoBD.PautaResultado;
import br.com.euPoliticoBD.PesquisaEleitoralResultado;
import br.com.euPoliticoConsultaDAO.ConsultaDAO;

/**
 * 
 * @author João Paulo
 * Controlador que contém a chamada a todos os métodos de acesso à classe de consulta ao banco de dados
 */
public class Controller {

	public List<PesquisaEleitoralResultado> getPesquisaEleitoral() {

		return new ConsultaDAO().getPesquisaEleitoral();
	}

	public List<EstatisticasCandidatosResultado> getEstatisticasCandidatos() {

		return new ConsultaDAO().getEstatisticasCandidatos();
	}

	public List<EstatisticasPoliticosResultado> getEstatisticasPoliticos() {

		return new ConsultaDAO().getEstatisticasPoliticos();
	}

	public List<EstatisticasEleitoradoResultado> getEstatisticasEleitorado() {

		return new ConsultaDAO().getEstatisticasEleitorado();
	}

	public List<AtualizacoesResultado> getAtualizacoes() {

		return new ConsultaDAO().getAtualizacoes();
	}

	public List<PautaResultado> getPauta() {

		return new ConsultaDAO().getPauta();
	}

	public List<ApuracaoVotosResultado> getApuracaoVotos() {

		return new ConsultaDAO().getApuracaoVotos();
	}

}
