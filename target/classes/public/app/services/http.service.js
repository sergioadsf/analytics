angular.module('analytics')
.factory('$httpService', HttpService);

function HttpService($http, $window){

	return {
		post: function(url, data, config){
			return $http.post($window.location.href.substring(0, $window.location.href.indexOf("#"))+url, data, config);
		}
	}
}