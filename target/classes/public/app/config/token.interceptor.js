angular.module('analytics')
.factory('TokenInterceptor', TokenInterceptor);

function TokenInterceptor($window, $q, $location){

	var interceptor = {};

	interceptor.response = function(response){
		var token = response.headers('x-access-token');

		if(token) {
			console.log("Token storage!");
			$window.sessionStorage.token = token;
		}

		return response;
	}

	interceptor.request = function(config) {
		config.headers = config.headers || {};
		if($window.sessionStorage.token){
			config.headers['x-access-token'] = $window.sessionStorage.token;
			console.log('Add token in the header');
		}

		return config;
	}

	interceptor.responseError = function(rejection){
		if(rejection != null && rejection.status == 401){
			delete $window.sessionStorage.token;
			$location.path("/")
		}

		return $q.reject(rejection)
	}

	return interceptor;
}