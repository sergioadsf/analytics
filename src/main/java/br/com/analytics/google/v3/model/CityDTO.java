package br.com.analytics.google.v3.model;

@SuppressWarnings("serial")
public class CityDTO extends GoogleTO {

	public CityDTO() {
	}

	public CityDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super(name, quantityAccess, txRejection, averageTime);
	}

}
