package br.com.analytics.google.v3.model.list;

import java.util.List;

import br.com.analytics.google.v3.model.VisitDTO;

public class ListVisitDTO extends ListDTO<VisitDTO> {

	private ListVisitDTO() {
	}

	public static ListVisitDTO start(List<VisitDTO> listVisit1) {
		return new ListVisitDTO(listVisit1);
	}

	private ListVisitDTO(List<VisitDTO> ListVisit1) {
		super();
		this.list1 = ListVisit1;
	}

	public ListVisitDTO addList2(List<VisitDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<VisitDTO> getListVisit1() {
		return list1;
	}

	public List<VisitDTO> getListVisit2() {
		return list2;
	}
}
