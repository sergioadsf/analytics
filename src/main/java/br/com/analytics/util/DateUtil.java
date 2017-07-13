package br.com.analytics.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class DateUtil implements Serializable {

	private static final long serialVersionUID = 7705705302388080001L;

	public static final String DD_MM_YYYY = "dd/MM/yyyy";

	public static final String DAY = "d";

	public static final String MONTH = "MM";

	public static final String YEAR = "yyyy";

	public static final String HH_MM = "HH:mm";

	public static final String DD_MM_YYYY_HH_MM = "dd/MM/yyyy HH:mm";

	public static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss";

	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static final String YYYY_MM_DD = "yyyy-MM-dd";

	public static final String HH = "HH";

	public static int getAno() {
		return getAno(new Date());
	}

	public static int getAno(final Date data) {
		return Integer.valueOf(formt(data, DateUtil.YEAR));
	}

	public static int getDia(final Date data) {
		return Integer.valueOf(formt(data, DateUtil.DAY));
	}

	public static Date setarValor(final Date data, final int field,
			final int valor) {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		gc.set(field, valor);

		return gc.getTime();
	}

	public static int getMes() {
		return getMes(new Date());
	}

	public static int getMes(final Date data) {
		return Integer.valueOf(formt(data, DateUtil.MONTH));
	}

	public static int getDiaMesAtual() {
		return Integer.valueOf(formt(new Date(), DateUtil.DAY));
	}

	public static String getData(final Date data) {
		return formt(data, DateUtil.DD_MM_YYYY);
	}

	public static String getData() {
		return formt(new Date(), DateUtil.DD_MM_YYYY);
	}

	public static String getDataHoras() {
		return formt(new Date(), DateUtil.DD_MM_YYYY_HH_MM_SS);
	}

	public static String getDataHoras(final Date data) {
		return formt(data, DateUtil.DD_MM_YYYY_HH_MM_SS);
	}

	public static String getDataHorasBanco(final Date data) {
		return formt(data, DateUtil.YYYY_MM_DD_HH_MM_SS);
	}

	public static String getDataBanco(final Date data) {
		return formt(data, DateUtil.YYYY_MM_DD);
	}

	public static String getHoras() {
		return formt(new Date(), "HH_MM");
	}

	public static int getHoraAtual() {
		return Integer.parseInt(formt(new Date(), HH));
	}

	public static Date somarData(final Date data, final Integer periodo) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(Calendar.DATE, periodo);
		return calendar.getTime();
	}

	private static Date addData(final Date data, final Integer periodo,
			final int field) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		calendar.add(field, periodo);
		return calendar.getTime();
	}

	public static Date comecoAnoAtual() {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		gc.set(Calendar.MONTH, 0);
		gc.set(Calendar.YEAR, 2012);
		return gc.getTime();
	}

	public static Date fimAnoAtual() {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date());
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);
		gc.set(Calendar.DAY_OF_MONTH, 31);
		gc.set(Calendar.MONTH, 11);
		return gc.getTime();
	}

	public static Date addMes(final Date data, final Integer periodo) {
		return addData(data, periodo, Calendar.MONTH);
	}

	public static Date addHora(final Date data, final Integer periodo) {
		return addData(data, periodo, Calendar.HOUR);
	}

	public static Date addAno(final Date data, final Integer periodo) {
		return addData(data, periodo, Calendar.YEAR);
	}

	public static Date subtrairAno(final Date data, final Integer periodo) {
		return addData(data, periodo * (-1), Calendar.YEAR);
	}

	public static Date subtrairMes(final Date data, final Integer periodo) {
		return addData(data, periodo * (-1), Calendar.MONTH);
	}

	public static Date somarMeses(final Date data, final Integer periodo) {
		return addData(data, periodo, Calendar.MONTH);
	}

	public static String formt(final Date data, final String pattern) {
		final SimpleDateFormat formatData = new SimpleDateFormat(pattern);
		return formatData.format(data);
	}

	public static String dataTime(final Date data, final boolean isZeroTime) {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		if (isZeroTime) {
			gc.set(Calendar.HOUR_OF_DAY, 0);
			gc.set(Calendar.MINUTE, 0);
			gc.set(Calendar.SECOND, 0);
			gc.set(Calendar.MILLISECOND, 0);

		}
		return getDataHorasBanco(gc.getTime());
	}

	public static int calcDiffMeses(final Date dateStart, final Date dateEnd) {
		int count = 0;
		if ((dateStart != null) && (dateEnd != null)
				&& dateStart.before(dateEnd)) {

			final Calendar clStart = Calendar.getInstance();
			clStart.setTime(dateStart);

			final Calendar clEnd = Calendar.getInstance();
			clEnd.setTime(dateEnd);

			while ((clStart.get(Calendar.MONTH) != clEnd.get(Calendar.MONTH))
					|| (clStart.get(Calendar.YEAR) != clEnd.get(Calendar.YEAR))) {
				clStart.add(Calendar.MONTH, 1);
				count++;
			}
		}
		return count;
	}

	public static Date getDataTimeComTime0(final Date data) {
		final GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(data);
		gc.set(Calendar.HOUR_OF_DAY, 0);
		gc.set(Calendar.MINUTE, 0);
		gc.set(Calendar.SECOND, 0);
		gc.set(Calendar.MILLISECOND, 0);

		return gc.getTime();
	}

	public static Date stringParaData(final String data) {
		final SimpleDateFormat format = new SimpleDateFormat(
				DD_MM_YYYY_HH_MM_SS);
		java.sql.Date dataFormatada = null;
		try {
			dataFormatada = new java.sql.Date(format.parse(data).getTime());
		} catch (final ParseException e) {
			// TODO: handle exception
		}
		return dataFormatada;
	}

	public static boolean isHorarioDeVerao(final Date data) {
		final Calendar c = Calendar.getInstance(TimeZone.getDefault());
		c.setTime(data);
		final int offset = c.get(Calendar.DST_OFFSET);
		return offset != 0;
	}

	public static String formataValor(String campo) {
		campo = filtraCampo(campo);
		final String vr = campo;
		final int tam = vr.length();

		if (tam <= 2) {
			campo = vr;
		}
		if ((tam > 2) && (tam <= 5)) {
			campo = vr.substring(0, tam - 2) + ',' + vr.substring(tam - 2, tam);
		}
		if ((tam >= 6) && (tam <= 8)) {
			campo = vr.substring(0, tam - 5) + '.' + vr.substring(tam - 5, 4)
					+ ',' + vr.substring(tam - 2, tam);
		}
		if ((tam >= 9) && (tam <= 11)) {
			campo = vr.substring(0, tam - 8) + vr.substring(tam - 8, 3)
					+ vr.substring(tam - 5, 3) + ','
					+ vr.substring(tam - 2, tam);
		}
		if ((tam >= 12) && (tam <= 14)) {
			campo = vr.substring(0, tam - 11) + vr.substring(tam - 11, 3)
					+ vr.substring(tam - 8, 3) + vr.substring(tam - 5, 3) + ','
					+ vr.substring(tam - 2, tam);
		}
		if ((tam >= 15) && (tam <= 17)) {
			campo = vr.substring(0, tam - 14) + vr.substring(tam - 14, 3)
					+ vr.substring(tam - 11, 3) + vr.substring(tam - 8, 3)
					+ vr.substring(tam - 5, 3) + ','
					+ vr.substring(tam - 2, tam);
		}
		return campo;
	}

	public static String filtraCampo(String campo) {
		String s = "";
		final String vr = campo;
		final int tam = vr.length();

		for (int i = 0; i < tam; i++) {
			if ((vr.substring(i, i + 1) != "/")
					&& (vr.substring(i, i + 1) != "-")
					&& (vr.substring(i, i + 1) != ".")
					&& (vr.substring(i, i + 1) != ",")) {
				s = s + vr.substring(i, i + 1);
			}
		}
		campo = s;
		return campo;
	}

	public static int calculaIdade(final Date dataReferencia,
			final Date dataNascimento) {
		final Calendar referencia = Calendar.getInstance();
		referencia.setTime(dataReferencia);
		final Calendar nascimento = Calendar.getInstance();
		nascimento.setTime(dataNascimento);

		// Idade baseada na diferença dos anos
		int idade = referencia.get(Calendar.YEAR)
				- nascimento.get(Calendar.YEAR);

		// Adicionar a suposta idade à data de nascimento
		nascimento.add(Calendar.YEAR, idade);

		// Se o aniversário desse ano não tiver acontecido ainda, subtrair um da
		// idade suposta
		if (referencia.before(nascimento)) {
			idade--;
		}

		return idade;
	}

	public static String getEstimatedTime(String tempoStr) {
		// Double tempo = 462.0;

		BigDecimal tempo = new BigDecimal(tempoStr)
				.setScale(2, RoundingMode.UP);

		BigDecimal tempoCorreto = tempo.divide(BigDecimal.valueOf(60),
				RoundingMode.UP);

		Integer minuto = tempoCorreto.divide(BigDecimal.valueOf(1),
				RoundingMode.HALF_EVEN).intValue();

		Integer resto = (int) ((tempoCorreto.doubleValue() % 1) * 60);

		return (minuto.toString().length() == 1 ? "0" + minuto : minuto) + "m "
				+ (resto.toString().length() == 1 ? "0" + resto : resto) + "s";

	}

	// public static String getEstimatedTime(String tempoStr) {
	// // Double tempo = 462.0;
	//
	// Double tempo = Double.valueOf(tempoStr);
	//
	// Integer tempoCorreto = (int) Math.abs(tempo / 60);
	//
	// Integer resto = (int) (tempo % 60);
	//
	// return (tempoCorreto.toString().length() == 1 ? "0" + tempoCorreto
	// : tempoCorreto)
	// + "m "
	// + (resto.toString().length() == 1 ? "0" + resto : resto) + "s";
	//
	// }

	public static String convertDateStrInToStr(String s) {
		if (s.contains("T")) {
			s = s.substring(0, s.indexOf("T"));
		}
		return s;
	}

	public static String inverteDataStrInParaStr(String s, char separador) {
		String[] valor = s.split("-");
		return valor[2] + separador + valor[1] + separador + valor[0];
	}

	public static Date converteStrToData(String data) {
		return converteStrToData(data, "yyyy-MM-dd");
	}

	public static String converteDateToStr(Date data) {
		return converteDateToStr(data, "dd/MM/yyyy");
	}

	public static String converteDateToStr(Date data, String pattern) {
		SimpleDateFormat f = new SimpleDateFormat(pattern);
		return f.format(data);
	}

	public static Date converteStrToData(String data, String pattern) {
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		try {
			return formatter.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	// public static String inverteDataStrInParaStr(String s, String separador)
	// {
	// String[] valor = s.split("-");
	// return valor[2] + separador + valor[1] + separador + valor[0];
	// }
	//

	public static void main(String[] args) throws ParseException {

		// 01/10/2014
		String data = "2014-10-01";
		String data2 = "2014-10-31";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date d = formatter.parse(data);
		Date d2 = formatter.parse(data2);
		// System.out.println(d);
		// System.out.println(addData(d2, 5, Calendar.DATE));
		List<Date> listaData = new ArrayList<Date>();

		while (d.before(d2)) {
			listaData.add(d);
			// System.out.println(d);
			d = addData(d, 7, Calendar.DATE);
		}

		for (Date date : listaData) {
			System.out.println(date);
		}
	}

}
