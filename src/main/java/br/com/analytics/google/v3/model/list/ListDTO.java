package br.com.analytics.google.v3.model.list;

import java.util.List;

public class ListDTO<T> {

	protected List<T> list1;
	protected List<T> list2;

	public ListDTO() {
	}

	public List<T> getList1() {
		return list1;
	}

	public List<T> getList2() {
		return list2;
	}

}
