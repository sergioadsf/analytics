package br.com.analytics.google.v3.model;

import br.com.analytics.BaseDTO;

@SuppressWarnings("serial")
public class WebPropertyDTO implements BaseDTO{

	private String id;
	private String name;
	private String kind;
	private String selfLink;

	public WebPropertyDTO(String id, String name, String kind, String selfLink) {
		super();
		this.id = id;
		this.name = name;
		this.kind = kind;
		this.selfLink = selfLink;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getKind() {
		return kind;
	}

	public String getSelfLink() {
		return selfLink;
	}

}
