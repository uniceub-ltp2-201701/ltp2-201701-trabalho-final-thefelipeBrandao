package model;

public class Genero {
	
	private int idGenero;
	private String nomeGenero;
	
	public Genero(int idGenero, String nomeGenero) {
		this.setIdGenero(idGenero);
		this.setNomeGenero(nomeGenero);
	}
	
	public int getIdGenero() {
		return idGenero;
	}
	
	public void setIdGenero(int idGenero) {
		this.idGenero = idGenero;
	}
	
	public String getNomeGenero() {
		return nomeGenero;
	}
	
	public void setNomeGenero(String nomeGenero) {
		this.nomeGenero = nomeGenero;
	}
	
	

}
