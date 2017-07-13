package br.com.analytics.google.v3.model;

import java.util.List;

public class ListCityDTO extends ListDTO<CityDTO> {

	private ListCityDTO() {
	}

	public static ListCityDTO start(List<CityDTO> listCity1) {
		return new ListCityDTO(listCity1);
	}

	private ListCityDTO(List<CityDTO> ListCity1) {
		super();
		this.list1 = ListCity1;
	}

	public ListCityDTO addList2(List<CityDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<CityDTO> getListCity1() {
		return list1;
	}

	public List<CityDTO> getListCity2() {
		return list2;
	}
}
