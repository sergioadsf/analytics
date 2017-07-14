package br.com.analytics.google.v3.model;

@SuppressWarnings("serial")
public class VisitDTO extends GoogleTO {

	public VisitDTO() {
	}

	public VisitDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super(name, quantityAccess, txRejection, averageTime);
	}

}
