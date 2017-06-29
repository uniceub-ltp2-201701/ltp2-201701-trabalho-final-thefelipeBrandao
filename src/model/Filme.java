package model;

import java.sql.Date;

public class Filme {

	private int idFilme;
	private String nomeFilme;
	private String ano;
	private Date dataLancamento;
	private int duracao;
	private String sinopse;
	private double avaliacao;
	private String classificacao;
	private String URLImagem;
	private int votos;


	public Filme(int idFilme,String nomeFilme,String ano,Date dataLancamento,int duracao,String sinopse,double avaliacao,String classificacao ) {
		this.setIdFilme(idFilme);
		this.setNomeFilme(nomeFilme);
		this.setAno(ano);
		this.setDataLancamento(dataLancamento);
		this.setDuracao(duracao);
		this.setSinopse(sinopse);
		this.setAvaliacao(avaliacao);
		this.setClassificacao(classificacao);
	}

	public Filme(int idFilme,String nomeFilme,String ano,Date dataLancamento,int duracao,String sinopse,double avaliacao,String classificacao,String urlImagem,int votos ) {
		this.setVotos(votos);
		this.setURLImagem(urlImagem);
		this.setIdFilme(idFilme);
		this.setNomeFilme(nomeFilme);
		this.setAno(ano);
		this.setDataLancamento(dataLancamento);
		this.setDuracao(duracao);
		this.setSinopse(sinopse);
		this.setAvaliacao(avaliacao);
		this.setClassificacao(classificacao);
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getDuracao() {
		return this.duracao + " min";
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public double getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(double avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getURLImagem() {
		return URLImagem;
	}

	public void setURLImagem(String uRLImagem) {
		URLImagem = uRLImagem;
	}
	

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	


}
