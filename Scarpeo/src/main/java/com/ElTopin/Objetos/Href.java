package com.ElTopin.Objetos;

public class Href {

	private String link;
	private String rel;
	
	public Href(String link, String rel) {
		this.link = link;
		this.rel = rel;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	
	
}
