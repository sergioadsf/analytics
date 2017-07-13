angular.module('analytics')
.factory('CityFactory', CityFactory);

function CityFactory($httpService){

	let _listCity = function(params){

		return $httpService.post(`city/listCity`, params);
	}

	let service = {
		listCity: _listCity,
	}

	return service;

}