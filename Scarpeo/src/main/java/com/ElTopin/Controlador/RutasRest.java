package com.ElTopin.Controlador;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ElTopin.Objetos.Keyword;
import com.ElTopin.Objetos.TodosDatos;
import com.ElTopin.Objetos.Url;
import com.ElTopin.Servicios.Metodos;

@RestController
public class RutasRest {
/*
	Document doc = Jsoup.connect("http://stackoverflow.com").userAgent("Mozilla").get();
    String title = doc.title(); 
    System.out.println("title is: " + title);  
    */
	
	@Autowired
	private Metodos metodos;

	
	@PostMapping("/post")
	public TodosDatos postIndex(@ModelAttribute Url urlDeLaPáginaABuscar) {
		TodosDatos salida = new TodosDatos();
		/*Creo un objeto donde esta el documento html*/
		Document docURL = null;
	
			try {
				docURL = Jsoup.connect(urlDeLaPáginaABuscar.getUrl()).userAgent("Mozilla").get(); /*Guardo la web en este objeto*/
			
				/*Extraigo la etiqueta <title></title>*/
			String title = docURL.title(); 
				/*Envio el titulo a la template*/
			salida.setTitulo(title);

				/*Extraigo y envio la etiqueta <meta></meta>*/
			salida.setDatosMeta(metodos.listaMeta(docURL.getElementsByTag("meta")));
				/*Extraigo y envio la etiqueta <a></a>*/
			salida.setDatosHref(metodos.listaEnlaces(docURL.getElementsByTag("a")));
			
			
			salida.setKeyword(metodos.listaKeyword(docURL.getElementsByTag("a"), docURL.getElementsByTag("p"), docURL.getElementsByTag("h1"), 
					 docURL.getElementsByTag("h2"), docURL.getElementsByTag("h3"), docURL.getElementsByTag("h4"), 
					 docURL.getElementsByTag("h5"), docURL.getElementsByTag("h6"), docURL.getElementsByTag("strong")));
			
			
			
			salida.setNumeroPalabras(metodos.numeroPalabras());
			
			salida.setNumeroImagenes(metodos.contarImagenes(docURL.getElementsByTag("img")));
			
			salida.setImagenes(metodos.listaImagenes(docURL.getElementsByTag("img")));
		
			
			return salida;
			
			} catch (IOException e) {
			
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}		
	}
	@PostMapping("/buscarKeyword")
	public Keyword postKeyword(@ModelAttribute Url palabraABuscar) {
		
		return metodos.buscarEnElTexto(palabraABuscar.getUrl());
	}
}
