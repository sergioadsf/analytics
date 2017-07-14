package br.com.analytics.google.v3.model.list;

import java.util.List;

import br.com.analytics.google.v3.model.ReferTrafficDTO;

public class ListReferTrafficDTO extends ListDTO<ReferTrafficDTO> {

	private ListReferTrafficDTO() {
	}

	public static ListReferTrafficDTO start(List<ReferTrafficDTO> listReferTraffic1) {
		return new ListReferTrafficDTO(listReferTraffic1);
	}

	private ListReferTrafficDTO(List<ReferTrafficDTO> ListReferTraffic1) {
		super();
		this.list1 = ListReferTraffic1;
	}

	public ListReferTrafficDTO addList2(List<ReferTrafficDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<ReferTrafficDTO> getListReferTraffic1() {
		return list1;
	}

	public List<ReferTrafficDTO> getListReferTraffic2() {
		return list2;
	}
}
