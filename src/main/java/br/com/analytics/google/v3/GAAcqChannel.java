package br.com.analytics.google.v3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.services.analytics.Analytics.Data.Ga;
import com.google.api.services.analytics.model.GaData;

import br.com.analytics.google.v3.model.AcqChannelDTO;
import br.com.analytics.google.v3.model.ParamsDTO;
import br.com.analytics.google.v3.model.list.ListAcqChannelDTO;
import br.com.analytics.util.DateUtil;

public class GAAcqChannel extends GA {

	private final static int NAME = 0;
	private final static int QUANTITY_ACCESS = 1;
	private final static int TX_REJEICTION = 2;
	private final static int AVERAGE = 3;

	private GAAcqChannel(Ga ga, String token, String idTable, String dateInit1, String dateEnd1, String dateInit2,
			String dateEnd2) {
		super(ga, token, idTable, dateInit1, dateEnd1, dateInit2, dateEnd2);
	}

	public static GAAcqChannel start(ParamsDTO params) throws IOException, Exception {
		Ga ga = Connection.getAnalytics(params.getToken()).data().ga();
		return new GAAcqChannel(ga, params.getToken(), params.getIdProfile(), params.getDateInit1(),
				params.getDateEnd1(), params.getDateInit2(), params.getDateEnd2());
	}

	public GAAcqChannel acqChannel() {
		this.acqChannel(super.maxResults);
		return this;
	}

	public GAAcqChannel acqChannel(Integer maxResult) {
		super.metrics = String.format("%s,%s,%s", GAParams.SESSOES, GAParams.TAXA_DE_REJEICAO,
				GAParams.TEMPO_MEDIO_SESSAO);
		super.setDimension(GAParams.DIM_TRAFEGO_TIPO);
		super.setSort(GAParams.SESSOES);
		super.setFilter(String.format("%s==%s",	GAParams.REFERENCIA_REDE_SOCIAL, "No"));
		return this;
	}

	public ListAcqChannelDTO execute() throws Exception {

		ListAcqChannelDTO list = ListAcqChannelDTO.start(execute(dateInit1, dateEnd1));

		if (dateInit2 != null && dateEnd2 != null) {
			super.setFilter(String.format("%s==%s",	GAParams.REFERENCIA_REDE_SOCIAL, "Yes"));
			list.addList2(execute(dateInit2, dateEnd2));
		}

		return list;
	}

	private List<AcqChannelDTO> execute(String dateInit, String dateEnd) throws Exception {
		if (ga == null) {
			throw new Exception("");
		}
		this.get = ga.get("ga:" + idTable, DateUtil.convertDateStrInToStr(dateInit),
				DateUtil.convertDateStrInToStr(dateEnd), metrics).setDimensions(dimensions).setMaxResults(maxResults).setFilters(filter);
		if (sort != null) {
			this.get.setSort(sort);
		}

		GaData results = get.execute();

		return convertList(results);
	}

	private List<AcqChannelDTO> convertList(GaData results) {
		List<AcqChannelDTO> list = new ArrayList<>();

		Object[] values = new Object[5];
		if (results.getRows() != null) {
			for (List<String> listaStr : results.getRows()) {
				values = listaStr.toArray();
				list.add(new AcqChannelDTO(values[NAME].toString(), values[QUANTITY_ACCESS].toString(),
						values[TX_REJEICTION].toString(), values[AVERAGE].toString()));
			}
		}

		return list;
	}
}
