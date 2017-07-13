package br.com.analytics.google.v3.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.analytics.BaseDTO;
import br.com.analytics.util.DateUtil;

@SuppressWarnings("serial")
public class CityDTO implements BaseDTO {

	private String name;
	private String averageTime;
	private BigDecimal quantityAccess;
	private BigDecimal txRejection;

	public CityDTO() {
	}

	public CityDTO(String name, String quantityAccess, String txRejection, String averageTime) {
		super();
		this.name = name;
		this.quantityAccess = new BigDecimal(quantityAccess);
		this.txRejection = new BigDecimal(txRejection).setScale(2, RoundingMode.HALF_EVEN);
		this.averageTime = DateUtil.getEstimatedTime(averageTime);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(String averageTime) {
		this.averageTime = averageTime;
	}

	public BigDecimal getQuantityAccess() {
		return quantityAccess;
	}

	public void setQuantityAccess(BigDecimal quantityAccess) {
		this.quantityAccess = quantityAccess;
	}

	public BigDecimal getTxRejection() {
		return txRejection;
	}

	public void setTxRejection(BigDecimal txRejection) {
		this.txRejection = txRejection;
	}

}
