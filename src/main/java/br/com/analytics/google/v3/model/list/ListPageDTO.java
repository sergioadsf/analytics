package br.com.analytics.google.v3.model.list;

import java.util.List;

import br.com.analytics.google.v3.model.PageDTO;

public class ListPageDTO extends ListDTO<PageDTO> {

	private ListPageDTO() {
	}

	public static ListPageDTO start(List<PageDTO> listPage1) {
		return new ListPageDTO(listPage1);
	}

	private ListPageDTO(List<PageDTO> ListPage1) {
		super();
		this.list1 = ListPage1;
	}

	public ListPageDTO addList2(List<PageDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<PageDTO> getListPage1() {
		return list1;
	}

	public List<PageDTO> getListPage2() {
		return list2;
	}
}
