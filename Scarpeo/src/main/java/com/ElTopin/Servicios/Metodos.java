package com.ElTopin.Servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Repository;

import com.ElTopin.Objetos.Href;
import com.ElTopin.Objetos.Imagenes;
import com.ElTopin.Objetos.Keyword;
import com.ElTopin.Objetos.Meta;

@Repository
public class Metodos {
	private String texto;

	public List<Meta> listaMeta(Elements metaTags) {
		List<Meta> listaMeta = new ArrayList<Meta>();
		for (Element metaTag : metaTags) {
			listaMeta.add(new Meta(metaTag.attr("content"), metaTag.attr("name")));
		}
		return listaMeta;
	}

	public List<Href> listaEnlaces(Elements url) {
		List<Href> listaUrl = new ArrayList<Href>();
		for (Element metaTag : url) {
			listaUrl.add(new Href(metaTag.attr("href"), metaTag.attr("rel")));
		}
		return listaUrl;
	}
	
	public List<Imagenes> listaImagenes(Elements imagenes) {
		List<Imagenes> listaImg = new ArrayList<Imagenes>();
		for (Element metaTag : imagenes) {
			listaImg.add(new Imagenes(metaTag.attr("src"), metaTag.attr("alt")));
			

		}
		return listaImg;
	}
	
	public Integer contarImagenes(Elements imagenes) {
		Integer numero = 0;
		for (Element metaTag : imagenes) {
			numero ++;
		}
		System.out.println(numero);
		return numero;
	}
	
	

	public List<Keyword> listaKeyword(Elements a, Elements p, Elements h1, Elements h2, Elements h3, Elements h4,
			Elements h5, Elements h6, Elements strong) {
		String contenidoViejo = extraerContenido(a) + extraerContenido(p) + extraerContenido(h1) + extraerContenido(h2)
				+ extraerContenido(h3) + extraerContenido(h4) + extraerContenido(h5) + extraerContenido(h6)
				+ extraerContenido(strong);
		String contenido = contenidoViejo.replace(",", "").replace(".", "").replace("¡", "").replace("!", "")
				.replace(":", "").replace("(", "").replace(")", "").replace("¿", "").replace("?", "").replace("{", "")
				.replace("}", "").replace("[", "").replace("]", "").replace("·", "").toLowerCase();
		String[] array = contenido.split("\\s+");
		this.texto = contenido;
		Map<String, Integer> datos = new HashMap<String, Integer>();
		for (String str : array) {
			if (datos.containsKey(str)) {
				datos.put(str, datos.get(str) + 1);
			} else {
				datos.put(str, 2);
			}
		}

		List<Entry<String, Integer>> lista = new ArrayList<>(datos.entrySet());
		lista.sort(Entry.comparingByValue());
		List<Keyword> almacen = new ArrayList<Keyword>();
		for (Entry<String, Integer> key : lista) {

			almacen.add(new Keyword(key.getKey(), key.getValue()));

		}
		return formatearKeyword(almacen);
	}

	public Integer numeroPalabras() {
		String[] array = this.texto.split("\\s+");
		return array.length;
	}

	/* Termine aqui tengo que contar las veces que aparece la palabra */
	public Keyword buscarEnElTexto(String palabraABuscar) {

		// Texto
		String sTexto = this.texto;
		// Texto que vamos a buscar
		String sTextoBuscado = palabraABuscar;
		// Contador de ocurrencias
		int contador = 0;

		while (sTexto.indexOf(sTextoBuscado) > -1) {
			sTexto = sTexto.substring(sTexto.indexOf(sTextoBuscado) + sTextoBuscado.length(), sTexto.length());
			contador++;
		}

		if (contador != 0) {
			contador = contador + 1;
		}

		return new Keyword(palabraABuscar, contador);

	}

	/* Metodos Privados */

	private String extraerContenido(Elements entrada) {
		String contenido = "";
		for (Element a : entrada) {
			contenido = contenido + " " + a.ownText();
		}

		return contenido;
	};

	private List<Keyword> formatearKeyword(List<Keyword> entrada) {
		List<Keyword> almacen = new ArrayList<Keyword>();

		for (Keyword key : entrada) {

			if (!key.getKeyword().equals("este") && !key.getKeyword().equals("les") && !key.getKeyword().equals("y")
					&& !key.getKeyword().equals("e") && !key.getKeyword().equals("o") && !key.getKeyword().equals("   ")
					&& !key.getKeyword().equals("  ") && !key.getKeyword().equals(" ") && !key.getKeyword().equals("")
					&& !key.getKeyword().equals("al") && !key.getKeyword().equals("pero")
					&& !key.getKeyword().equals("aquellos") && !key.getKeyword().equals("aquellas")
					&& !key.getKeyword().equals("aquello") && !key.getKeyword().equals("aquella")
					&& !key.getKeyword().equals("esos") && !key.getKeyword().equals("esas")
					&& !key.getKeyword().equals("eso") && !key.getKeyword().equals("esa")
					&& !key.getKeyword().equals("estos") && !key.getKeyword().equals("estas")
					&& !key.getKeyword().equals("esta") && !key.getKeyword().equals("este")
					&& !key.getKeyword().equals("que") && !key.getKeyword().equals("a")
					&& !key.getKeyword().equals("ante") && !key.getKeyword().equals("bajo")
					&& !key.getKeyword().equals("dentro") && !key.getKeyword().equals("cabe")
					&& !key.getKeyword().equals("con") && !key.getKeyword().equals("contra")
					&& !key.getKeyword().equals("de") && !key.getKeyword().equals("desde")
					&& !key.getKeyword().equals("durante") && !key.getKeyword().equals("en")
					&& !key.getKeyword().equals("entre") && !key.getKeyword().equals("hacia")
					&& !key.getKeyword().equals("hasta") && !key.getKeyword().equals("mediante")
					&& !key.getKeyword().equals("para") && !key.getKeyword().equals("por")
					&& !key.getKeyword().equals("según") && !key.getKeyword().equals("sin")
					&& !key.getKeyword().equals("so") && !key.getKeyword().equals("sobre")
					&& !key.getKeyword().equals("tras") && !key.getKeyword().equals("versus")
					&& !key.getKeyword().equals("vía") && !key.getKeyword().equals("si")
					&& !key.getKeyword().equals("no") && !key.getKeyword().equals("el")
					&& !key.getKeyword().equals("la") && !key.getKeyword().equals("lo")
					&& !key.getKeyword().equals("los") && !key.getKeyword().equals("las")
					&& !key.getKeyword().equals("un") && !key.getKeyword().equals("una")
					&& !key.getKeyword().equals("unos") && !key.getKeyword().equals("unas")) {

				almacen.add(key);
			}
		}
		Collections.reverse(almacen);
		return almacen;
	}

}
