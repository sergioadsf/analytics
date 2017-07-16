angular.module('analytics').factory('DeviceFactory', DeviceFactory);

function DeviceFactory($httpService) {

	let _listDevice = function(params) {

		return $httpService.post(`device/listDevice`, params);
	}

	let service = {
		listDevice : _listDevice,
	}

	return service;

}