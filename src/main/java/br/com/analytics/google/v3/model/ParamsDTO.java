package br.com.analytics.google.v3.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("serial")
@XmlRootElement
public class ParamsDTO implements Serializable {

	private String token;

	private String idAccount;

	private String idWebProperty;

	private String idProfile;

	private String dateInit1;

	private String dateEnd1;

	private String dateInit2;

	private String dateEnd2;

	public ParamsDTO() {
	}

	public String getToken() {
		return token;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public String getIdWebProperty() {
		return idWebProperty;
	}

	public String getDateInit1() {
		return dateInit1;
	}

	public String getDateEnd1() {
		return dateEnd1;
	}

	public String getDateInit2() {
		return dateInit2;
	}

	public String getDateEnd2() {
		return dateEnd2;
	}

	public String getIdProfile() {
		return idProfile;
	}

}
