package br.com.analytics.dto;

import java.util.List;

import br.com.analytics.BaseDTO;
import br.com.analytics.google.v3.model.AccountDTO;

@SuppressWarnings("serial")
public class DashboardDTO implements BaseDTO {

	List<AccountDTO> accounts;

	public DashboardDTO() {
	}

	public List<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}

}
