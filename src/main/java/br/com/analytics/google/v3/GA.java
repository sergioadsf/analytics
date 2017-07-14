package br.com.analytics.google.v3;

import java.io.IOException;

import com.google.api.services.analytics.Analytics.Data.Ga;
import com.google.api.services.analytics.Analytics.Data.Ga.Get;

import br.com.analytics.google.v3.model.ListDTO;

public class GA extends GAParams {

	protected Ga ga;

	protected Get get;

	protected String token;

	protected String idTable;

	protected String dateInit1;

	protected String dateEnd1;

	protected String dateInit2;

	protected String dateEnd2;

	protected String metrics;

	protected String dimensions;

	protected String sort;

	protected String filter;

	protected Integer maxResults;

	GA(Ga ga, String token, String idTable, String dateInit1, String dateEnd1) {
		this(ga, token, idTable, dateInit1, dateEnd1, null, null);
	}

	GA(Ga ga, String token, String idTable, String dateInit1, String dateEnd1, String dateInit2, String dateEnd2) {
		super();
		this.ga = ga;
		this.token = token;
		this.idTable = idTable;
		this.dateInit1 = dateInit1;
		this.dateEnd1 = dateEnd1;
		this.dateInit2 = dateInit2;
		this.dateEnd2 = dateEnd2;
		this.dimensions = "15";
		this.maxResults = 5;
	}

	public static GA start(String token, String idTable, String dateInit, String dateEnd)
			throws IOException, Exception {
		Ga ga = Connection.getAnalytics(token).data().ga();
		return new GA(ga, token, idTable, dateInit, dateEnd, null, null);
	}

	public static GA start(String token, String idTable, String dateInit1, String dateEnd1, String dateInit2,
			String dateEnd2) throws IOException, Exception {
		Ga ga = Connection.getAnalytics(token).data().ga();
		return new GA(ga, token, idTable, dateInit1, dateEnd1, dateInit2, dateEnd2);
	}

	public GA getSessions() {
		this.metrics = SESSOES;
		return this;
	}

	public void setMetrics(String metrics) {
		this.metrics = metrics;
	}

	public void setSort(String sort) {
		this.sort = String.format("-%s", sort);
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public GA setDimension(String dimensions) {
		this.dimensions = String.format("%s", dimensions);
		return this;
	}

	// TODO back later
	public ListDTO<?> execute() throws Exception {
		this.get = ga.get("ga:" + idTable, dateInit1, dateEnd1, metrics).setDimensions(dimensions)
				.setMaxResults(maxResults);
		if (sort != null) {
			this.get.setSort(sort);
		}

		// GaData results = get.execute();
		return null;
	}

}