package br.com.analytics.google.v3.model.list;

import java.util.List;

import br.com.analytics.google.v3.model.DeviceDTO;

public class ListDeviceDTO extends ListDTO<DeviceDTO> {

	private ListDeviceDTO() {
	}

	public static ListDeviceDTO start(List<DeviceDTO> listDevice1) {
		return new ListDeviceDTO(listDevice1);
	}

	private ListDeviceDTO(List<DeviceDTO> ListDevice1) {
		super();
		this.list1 = ListDevice1;
	}

	public ListDeviceDTO addList2(List<DeviceDTO> list2) {
		this.list2 = list2;
		return this;
	}

	public List<DeviceDTO> getListDevice1() {
		return list1;
	}

	public List<DeviceDTO> getListDevice2() {
		return list2;
	}
}
