angular.module('analytics').factory('PageFactory', PageFactory);

function PageFactory($httpService) {

	let _listPage = function(params) {

		return $httpService.post(`page/listPage`, params);
	}

	let service = {
		listPage : _listPage,
	}

	return service;

}