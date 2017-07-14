package br.com.analytics.google.v3.model.list;

import java.util.List;

import br.com.analytics.google.v3.model.AcqChannelDTO;

public class ListAcqChannelDTO extends ListDTO<AcqChannelDTO> {

	private ListAcqChannelDTO() {
	}

	public static ListAcqChannelDTO start(List<AcqChannelDTO> listAcqChannel1) {
		return new ListAcqChannelDTO(listAcqChannel1);
	}

	private ListAcqChannelDTO(List<AcqChannelDTO> ListAcqChannel1) {
		super();
		this.list1 = ListAcqChannel1;
	}

	public ListAcqChannelDTO addList2(List<AcqChannelDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<AcqChannelDTO> getListAcqChannel1() {
		return list1;
	}

	public List<AcqChannelDTO> getListAcqChannel2() {
		return list2;
	}
}
