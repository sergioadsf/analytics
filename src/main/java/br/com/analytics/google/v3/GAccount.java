package br.com.analytics.google.v3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;

import com.google.api.services.analytics.model.Accounts;

import br.com.analytics.google.v3.model.AccountDTO;

public class GAccount {

	private String token;

	private List<AccountDTO> accounts;

	private GAccount(String token) {
		this.token = token;
		this.accounts = new ArrayList<>();
	}

	public static GAccount start(String token) throws AccountException {
		if (token == null)
			throw new AccountException("Token não pode ser vazio.");

		return new GAccount(token);
	}

	public GAccount accounts() throws IOException, Exception {
		Accounts accounts = Connection.getAnalytics(token).management().accounts().list().execute();
		accounts.getItems().forEach(
				ac -> this.accounts.add(new AccountDTO(ac.getId(), ac.getName(), ac.getKind(), ac.getSelfLink())));

		return this;
	}

	public String getToken() {
		return token;
	}

	public List<AccountDTO> getAccounts() {
		return accounts;
	}

}
