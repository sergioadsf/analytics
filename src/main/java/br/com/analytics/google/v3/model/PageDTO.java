package br.com.analytics.google.v3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.analytics.util.DateUtil;

@SuppressWarnings("serial")
public class PageDTO extends GoogleTO {

	private String title;
	private String path;

	public PageDTO() {
	}

	public PageDTO(String title, String path, String quantityAccess, String txRejection, String averageTime) {
		super();
		this.title = title;
		this.path = path;
		this.quantityAccess = new BigDecimal(quantityAccess);
		this.txRejection = new BigDecimal(txRejection).setScale(2, RoundingMode.HALF_EVEN);
		this.averageTime = DateUtil.getEstimatedTime(averageTime);
	}

	public String getTitle() {
		return title;
	}

	public String getPath() {
		return path;
	}

}
