package br.com.analytics.google.v3.model;

@SuppressWarnings("serial")
public class AdviceDTO extends GoogleTO {

	public AdviceDTO() {
	}

	public AdviceDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super(name, quantityAccess, txRejection, averageTime);
	}

}
