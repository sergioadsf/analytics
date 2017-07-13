angular.module('analytics')
.factory('LoginFactory', LoginFactory);

function LoginFactory($httpService){

	let _connect = function(codeOffline){
		
		return $httpService.post(`dashboard/tokenResponse`, codeOffline.code);
	}

	let service = {
		connect: _connect,
	}

	return service;
}