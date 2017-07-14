angular.module('analytics').factory('VisitFactory', VisitFactory);

function VisitFactory($httpService) {

	let _listVisit = function(params) {

		return $httpService.post(`visit/listVisit`, params);
	}

	let service = {
		listVisit : _listVisit,
	}

	return service;

}