package br.com.analytics.google.v3.model;

@SuppressWarnings("serial")
public class AcqChannelDTO extends GoogleTO {

	public AcqChannelDTO() {
	}

	public AcqChannelDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super(name, quantityAccess, txRejection, averageTime);
	}

}
