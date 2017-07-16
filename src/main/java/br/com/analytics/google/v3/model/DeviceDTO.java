package br.com.analytics.google.v3.model;

@SuppressWarnings("serial")
public class DeviceDTO extends GoogleTO {

	public DeviceDTO() {
	}

	public DeviceDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super(name, quantityAccess, txRejection, averageTime);
	}

}
