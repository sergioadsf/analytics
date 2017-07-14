package br.com.analytics.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalcUtils {

	public static BigDecimal calcPercentage(BigDecimal total, BigDecimal value) {
		BigDecimal totalBig = total.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal valorBig = value.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal cemBig = new BigDecimal(100).setScale(2, RoundingMode.HALF_EVEN);

		valorBig = valorBig.multiply(cemBig).setScale(2, RoundingMode.HALF_EVEN);
		return valorBig.divide(totalBig, 2, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal calcDifferentSessions(BigDecimal qtdActual, BigDecimal qtdPast) {
		if (qtdPast.compareTo(new BigDecimal(0)) == 0) {
			return new BigDecimal(0);
		}

		BigDecimal actBig = qtdActual.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal pastBig = qtdPast.setScale(2, RoundingMode.HALF_EVEN);
		BigDecimal hundBig = new BigDecimal(100).setScale(2, RoundingMode.HALF_EVEN);

		actBig = actBig.subtract(pastBig);
		actBig = actBig.multiply(hundBig);
		return actBig.divide(pastBig, 2, RoundingMode.HALF_EVEN);
	}

	public static BigDecimal calcularTempo(String timeAverage) {
		timeAverage = timeAverage.replace("m", "").replace("s", "");
		String[] time = timeAverage.split(" ");
		BigDecimal min = new BigDecimal(time[0].trim());
		BigDecimal seg = new BigDecimal(time[1].trim());
		min = min.multiply(new BigDecimal(60));
		return min.add(seg);
	}
}
