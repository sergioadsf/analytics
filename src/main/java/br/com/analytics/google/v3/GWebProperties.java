package br.com.analytics.google.v3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;

import com.google.api.services.analytics.model.Webproperties;

import br.com.analytics.google.v3.model.WebPropertyDTO;

public class GWebProperties {

	private String token;

	private List<WebPropertyDTO> webroperties;

	private GWebProperties(String token) {
		this.token = token;
		this.webroperties = new ArrayList<>();
	}

	public static GWebProperties start(String token) throws AccountException {
		if (token == null)
			throw new AccountException("Token não pode ser vazio.");

		return new GWebProperties(token);
	}

	public GWebProperties webproperties(String idAccount) throws IOException, Exception {
		Webproperties webproperties = Connection.getAnalytics(token).management().webproperties().list(idAccount)
				.execute();
		webproperties.getItems().forEach(prof -> this.webroperties
				.add(new WebPropertyDTO(prof.getId(), prof.getName(), prof.getKind(), prof.getSelfLink())));

		return this;
	}

	public String getToken() {
		return token;
	}

	public List<WebPropertyDTO> getWebProperties() {
		return webroperties;
	}

}
