angular.module('analytics').factory('ReferTrafficFactory', ReferTrafficFactory);

function ReferTrafficFactory($httpService) {

	let _listReferTraffic = function(params) {

		return $httpService.post(`referTraffic/listReferTraffic`, params);
	}

	let service = {
		listReferTraffic : _listReferTraffic,
	}

	return service;
}