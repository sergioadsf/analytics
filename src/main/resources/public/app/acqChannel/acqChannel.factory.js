angular.module('analytics').factory('AcqChannelFactory', AcqChannelFactory);

function AcqChannelFactory($httpService) {

	let _listAcqChannel = function(params) {

		return $httpService.post(`acqChannel/listAcqChannel`, params);
	}

	let service = {
		listAcqChannel : _listAcqChannel,
	}

	return service;

}