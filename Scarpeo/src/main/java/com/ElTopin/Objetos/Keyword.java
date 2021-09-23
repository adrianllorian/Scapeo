package com.ElTopin.Objetos;

public class Keyword {

	private String keyword;
	private Integer numero;
	
	public Keyword() {
		
	}
	public Keyword(String keyword, Integer numero) {
		this.keyword= keyword;
		this.numero = numero;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
