package model;

import java.sql.Date;

public class Integrante {
	
	private int idIntegrante;
	private String nome;
	private String genero;
	private String biografia;
	private Date nascimento;
	private String urlImagem;
	
	public Integrante(int idIntegrante,String nome, String genero, String biografia, Date nascimento) {
		this.setIdIntegrante(idIntegrante);
		this.setNome(nome);
		this.setGenero(genero);
		this.setBiografia(biografia);
		this.setNascimento(nascimento);
	}
	
	public Integrante(int idIntegrante,String nome, String genero, String biografia, Date nascimento,String urlImagem) {
		this.setUrlImagem(urlImagem);
		this.setIdIntegrante(idIntegrante);
		this.setNome(nome);
		this.setGenero(genero);
		this.setBiografia(biografia);
		this.setNascimento(nascimento);
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	public int getIdIntegrante() {
		return idIntegrante;
	}
	
	public void setIdIntegrante(int idIntegrante) {
		this.idIntegrante = idIntegrante;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getGenero() {
		return this.genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getBiografia() {
		return biografia;
	}
	
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	
	public Date getNascimento() {
		return nascimento;
	}
	
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	
	public String getGeneroNome() {
		if(this.genero.equals("M"))
			return "Masculino";
		else
			return "Feminino";
	}
	
	
	
	
}
