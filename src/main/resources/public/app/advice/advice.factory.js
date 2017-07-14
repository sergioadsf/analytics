angular.module('analytics').factory('AdviceFactory', AdviceFactory);

function AdviceFactory($httpService) {

	let _listAdvice = function(params) {

		return $httpService.post(`advice/listAdvice`, params);
	}

	let service = {
		listAdvice : _listAdvice,
	}

	return service;

}