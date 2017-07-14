package br.com.analytics.google.v3.model;

import java.util.List;

public class ListAdviceDTO extends ListDTO<AdviceDTO> {

	private ListAdviceDTO() {
	}

	public static ListAdviceDTO start(List<AdviceDTO> listAdvice1) {
		return new ListAdviceDTO(listAdvice1);
	}

	private ListAdviceDTO(List<AdviceDTO> ListAdvice1) {
		super();
		this.list1 = ListAdvice1;
	}

	public ListAdviceDTO addList2(List<AdviceDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<AdviceDTO> getListAdvice1() {
		return list1;
	}

	public List<AdviceDTO> getListAdvice2() {
		return list2;
	}
}
