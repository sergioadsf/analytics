package br.com.analytics.google.v3.model;

@SuppressWarnings("serial")
public class ReferTrafficDTO extends GoogleTO {

	public ReferTrafficDTO() {
	}

	public ReferTrafficDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super(name, quantityAccess, txRejection, averageTime);
	}

}
