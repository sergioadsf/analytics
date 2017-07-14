package br.com.analytics.google.v3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.api.services.analytics.Analytics.Data.Ga;
import com.google.api.services.analytics.model.GaData;

import br.com.analytics.google.v3.model.ListPageDTO;
import br.com.analytics.google.v3.model.PageDTO;
import br.com.analytics.google.v3.model.ParamsDTO;
import br.com.analytics.util.DateUtil;

public class GAPage extends GA {

	private final static int TITLE = 0;
	private final static int PATH = 1;
	private final static int QUANTITY_ACCESS = 2;
	private final static int TX_REJEICTION = 3;
	private final static int AVERAGE = 4;

	private GAPage(Ga ga, String token, String idTable, String dateInit1, String dateEnd1, String dateInit2,
			String dateEnd2) {
		super(ga, token, idTable, dateInit1, dateEnd1, dateInit2, dateEnd2);
	}

	public static GAPage start(ParamsDTO params) throws IOException, Exception {
		Ga ga = Connection.getAnalytics(params.getToken()).data().ga();
		return new GAPage(ga, params.getToken(), params.getIdProfile(), params.getDateInit1(), params.getDateEnd1(),
				params.getDateInit2(), params.getDateEnd2());
	}

	public GAPage page() {
		this.page(super.maxResults);
		return this;
	}

	public GAPage page(Integer maxResult) {
		super.metrics = String.format("%s,%s,%s", GAParams.PAGINA_VISITADAS, GAParams.TAXA_DE_REJEICAO,
				GAParams.PAGINA_TEMPO_MEDIO);
		super.setDimension(String.format("%s,%s", GAParams.DIM_PAGINA_TITULO, GAParams.DIM_PAGINA_CAMINHO));
		super.setSort(GAParams.PAGINA_VISITADAS);
		return this;
	}

	public ListPageDTO execute() throws Exception {

		ListPageDTO list = ListPageDTO.start(execute(dateInit1, dateEnd1));

		if (dateInit2 != null && dateEnd2 != null) {
			list.addList2(execute(dateInit2, dateEnd2));
		}

		return list;
	}

	private List<PageDTO> execute(String dateInit, String dateEnd) throws Exception {
		if (ga == null) {
			throw new Exception("");
		}
		this.get = ga.get("ga:" + idTable, DateUtil.convertDateStrInToStr(dateInit),
				DateUtil.convertDateStrInToStr(dateEnd), metrics).setDimensions(dimensions).setMaxResults(maxResults);
		if (sort != null) {
			this.get.setSort(sort);
		}

		GaData results = get.execute();

		return convertList(results);
	}

	private List<PageDTO> convertList(GaData results) {
		List<PageDTO> list = new ArrayList<>();

		Object[] values = new Object[5];
		if (results.getRows() != null) {
			for (List<String> listaStr : results.getRows()) {
				values = listaStr.toArray();
				list.add(new PageDTO(values[TITLE].toString(), values[PATH].toString(),
						values[QUANTITY_ACCESS].toString(), values[TX_REJEICTION].toString(),
						values[AVERAGE].toString()));
			}
		}

		return list;
	}
}
