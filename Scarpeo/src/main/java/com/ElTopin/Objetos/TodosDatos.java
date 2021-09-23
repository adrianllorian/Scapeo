package com.ElTopin.Objetos;

import java.util.List;

public class TodosDatos {

	private String titulo;
	
	private List <Meta> datosMeta;
	
	private List <Href> datosHref;
	
	private List <Keyword> keyword;
	
	private Integer numeroPalabras;
	
	private Integer numeroImagenes;
	
	private List <Imagenes> datosImagenes;
	

	public Integer getNumeroPalabras() {
		return numeroPalabras;
	}

	public void setNumeroPalabras(Integer numeroPalabras) {
		this.numeroPalabras = numeroPalabras;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Meta> getDatosMeta() {
		return datosMeta;
	}

	public void setDatosMeta(List<Meta> datosMeta) {
		this.datosMeta = datosMeta;
	}

	public List<Href> getDatosHref() {
		return datosHref;
	}

	public void setDatosHref(List<Href> datosHref) {
		this.datosHref = datosHref;
	}

	public List<Keyword> getKeyword() {
		return keyword;
	}

	public void setKeyword(List<Keyword> keyword) {
		this.keyword = keyword;
	}

	public List<Imagenes> getImagenes() {
		return datosImagenes;
	}

	public void setImagenes(List<Imagenes> imagenes) {
		this.datosImagenes = imagenes;
	}

	public Integer getNumeroImagenes() {
		return numeroImagenes;
	}

	public void setNumeroImagenes(Integer numeroImagenes) {
		this.numeroImagenes = numeroImagenes;
	}
	
	
	
	

	
}
