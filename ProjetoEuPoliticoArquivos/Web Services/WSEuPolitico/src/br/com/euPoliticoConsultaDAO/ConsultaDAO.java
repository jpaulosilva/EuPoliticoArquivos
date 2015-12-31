package br.com.euPoliticoConsultaDAO;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import br.com.euPoliticoBD.ApuracaoVotos;
import br.com.euPoliticoBD.ApuracaoVotosResultado;
import br.com.euPoliticoBD.Atualizacoes;
import br.com.euPoliticoBD.AtualizacoesResultado;
import br.com.euPoliticoBD.EstatisticasCandidatos;
import br.com.euPoliticoBD.EstatisticasCandidatosResultado;
import br.com.euPoliticoBD.EstatisticasEleitorado;
import br.com.euPoliticoBD.EstatisticasEleitoradoResultado;
import br.com.euPoliticoBD.EstatisticasPoliticos;
import br.com.euPoliticoBD.EstatisticasPoliticosResultado;
import br.com.euPoliticoBD.Pauta;
import br.com.euPoliticoBD.PautaResultado;
import br.com.euPoliticoBD.PesquisaEleitoral;
import br.com.euPoliticoBD.PesquisaEleitoralResultado;
import br.com.euPoliticoConexaoDAO.PMF;

/**
 * 
 * @author João Paulo
 * Onde as chamadas ao banco de dados são efetuadas	
 */
public class ConsultaDAO {
	
	//Método que retorna uma lista com as Pesquisas Eleitorais
	public List<PesquisaEleitoralResultado> getPesquisaEleitoral() {
		
		//Abrindo conexão com o BD
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		//Instaciando uma consulta ao BD
		Query q = pm.newQuery(PesquisaEleitoral.class);
		
		//Ordenando o resultado da consulta por "ID", de forma crescente
		q.setOrdering("id asc");

		List<PesquisaEleitoral> resultSet = null;
		List<PesquisaEleitoralResultado> resultadoBusca = new ArrayList<>();

		try {
			//Executando a consulta ao BD
			resultSet = (List<PesquisaEleitoral>) q.execute();

			if (!resultSet.isEmpty()) {
				for (PesquisaEleitoral pe : resultSet) {

					PesquisaEleitoralResultado per = new PesquisaEleitoralResultado();
					
					//Setando o retorno da consulta na classe de resultados
					per.setId(pe.getId());
					per.setEstado(pe.getEstado());
					per.setCidade(pe.getCidade());
					per.setCargo(pe.getCargo());
					per.setNumeroCandidato(pe.getNumeroCandidato());
					per.setNomeCandidato(pe.getNomeCandidato());
					per.setQtdVotos(pe.getQtdVotos());
					per.setInstitutoPesquisa(pe.getInstitutoPesquisa());

					resultadoBusca.add(per);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}
	
	
	public List<EstatisticasCandidatosResultado> getEstatisticasCandidatos() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(EstatisticasCandidatos.class);

		q.setOrdering("id asc");

		List<EstatisticasCandidatos> resultSet = null;
		List<EstatisticasCandidatosResultado> resultadoBusca = new ArrayList<>();

		try {
			resultSet = (List<EstatisticasCandidatos>) q.execute();

			if (!resultSet.isEmpty()) {
				for (EstatisticasCandidatos ec : resultSet) {

					EstatisticasCandidatosResultado ecr = new EstatisticasCandidatosResultado();

					ecr.setId(ec.getId());
					ecr.setEstado(ec.getEstado());
					ecr.setCidade(ec.getCidade());
					ecr.setCargo(ec.getCargo());
					ecr.setPartido(ec.getPartido());
					ecr.setTotalBens(ec.getTotalBens());
					ecr.setTotalDoacoes(ec.getTotalDoacoes());
					ecr.setGastosCampanha(ec.getGastosCampanha());

					resultadoBusca.add(ecr);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}
	
	public List<EstatisticasPoliticosResultado> getEstatisticasPoliticos() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(EstatisticasPoliticos.class);

		q.setOrdering("id asc");

		List<EstatisticasPoliticos> resultSet = null;
		List<EstatisticasPoliticosResultado> resultadoBusca = new ArrayList<>();

		try {
			resultSet = (List<EstatisticasPoliticos>) q.execute();

			if (!resultSet.isEmpty()) {
				for (EstatisticasPoliticos ep : resultSet) {

					EstatisticasPoliticosResultado epr = new EstatisticasPoliticosResultado();

					epr.setId(ep.getId());
					epr.setEstado(ep.getEstado());
					epr.setCidade(ep.getCidade());
					epr.setCargo(ep.getCargo());
					epr.setPartido(ep.getPartido());
					epr.setEscolaridadeEnsinoMedio(ep.getEscolaridadeEnsinoMedio());
					epr.setFaixaEtariaMedia(ep.getFaixaEtariaMedia());

					resultadoBusca.add(epr);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}
	
	public List<EstatisticasEleitoradoResultado> getEstatisticasEleitorado() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(EstatisticasEleitorado.class);

		q.setOrdering("id asc");

		List<EstatisticasEleitorado> resultSet = null;
		List<EstatisticasEleitoradoResultado> resultadoBusca = new ArrayList<>();

		try {
			resultSet = (List<EstatisticasEleitorado>) q.execute();

			if (!resultSet.isEmpty()) {
				for (EstatisticasEleitorado ee : resultSet) {

					EstatisticasEleitoradoResultado eer = new EstatisticasEleitoradoResultado();

					eer.setId(ee.getId());
					eer.setEstado(ee.getEstado());
					eer.setCidade(ee.getCidade());
					eer.setQtdEleitores(ee.getQtdEleitores());
					eer.setFaixaEtariaMedia(ee.getFaixaEtariaMedia());
					
					resultadoBusca.add(eer);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}
	
	
	public List<AtualizacoesResultado> getAtualizacoes() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(Atualizacoes.class);

		q.setOrdering("id asc");

		List<Atualizacoes> resultSet = null;
		List<AtualizacoesResultado> resultadoBusca = new ArrayList<>();

		try {
			resultSet = (List<Atualizacoes>) q.execute();

			if (!resultSet.isEmpty()) {
				for (Atualizacoes atual : resultSet) {

					AtualizacoesResultado atualResultado = new AtualizacoesResultado();

					atualResultado.setId(atual.getId());
					atualResultado.setEstado(atual.getEstado());
					atualResultado.setCidade(atual.getCidade());
					atualResultado.setCargo(atual.getCargo());
					atualResultado.setPoliticoAcompanhado(atual.getPoliticoAcompanhado());
					atualResultado.setNovidades(atual.getNovidades());

					resultadoBusca.add(atualResultado);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}
	
	public List<PautaResultado> getPauta() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(Pauta.class);

		q.setOrdering("id asc");

		List<Pauta> resultSet = null;
		List<PautaResultado> resultadoBusca = new ArrayList<>();

		try {
			resultSet = (List<Pauta>) q.execute();

			if (!resultSet.isEmpty()) {
				for (Pauta p : resultSet) {

					PautaResultado pr = new PautaResultado();

					pr.setId(p.getId());
					pr.setAssunto(p.getAssunto());
					pr.setData(p.getData());
					pr.setHorario(p.getHorario());
					

					resultadoBusca.add(pr);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}
	
	public List<ApuracaoVotosResultado> getApuracaoVotos() {

		PersistenceManager pm = PMF.get().getPersistenceManager();

		Query q = pm.newQuery(ApuracaoVotos.class);

		q.setOrdering("id asc");

		List<ApuracaoVotos> resultSet = null;
		List<ApuracaoVotosResultado> resultadoBusca = new ArrayList<>();

		try {
			resultSet = (List<ApuracaoVotos>) q.execute();

			if (!resultSet.isEmpty()) {
				for (ApuracaoVotos av : resultSet) {

					ApuracaoVotosResultado avr = new ApuracaoVotosResultado();

					avr.setId(av.getId());
					avr.setEstado(av.getEstado());
					avr.setCidade(av.getCidade());
					avr.setCargo(av.getCargo());
					avr.setNumeroCandidato(av.getNumeroCandidato());
					avr.setCandidato(av.getCandidato());
					avr.setNumeroVotos(av.getNumeroVotos());
					avr.setPorcentagemVotos(av.getPorcentagemVotos());

					resultadoBusca.add(avr);

				}
			}
		} finally {
			q.closeAll();
			pm.close();
		}

		return resultadoBusca;
	}


}
