package br.com.analytics.google.v3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;

import com.google.api.services.analytics.model.Profiles;

import br.com.analytics.google.v3.model.ProfileDTO;

public class GProfile {

	private String token;

	private List<ProfileDTO> profiles;

	private GProfile(String token) {
		this.token = token;
		this.profiles = new ArrayList<>();
	}

	public static GProfile start(String token) throws AccountException {
		if (token == null)
			throw new AccountException("Token não pode ser vazio.");

		return new GProfile(token);
	}

	public GProfile profiles(String idAccount, String idWebProperty) throws IOException, Exception {
		Profiles profiles = Connection.getAnalytics(token).management().profiles().list(idAccount, idWebProperty)
				.execute();
		profiles.getItems().forEach(prof -> this.profiles
				.add(new ProfileDTO(prof.getId(), prof.getName(), prof.getKind(), prof.getSelfLink())));

		return this;
	}

	public String getToken() {
		return token;
	}

	public List<ProfileDTO> getProfiles() {
		return profiles;
	}

}
