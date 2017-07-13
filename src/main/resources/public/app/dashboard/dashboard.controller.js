angular.module('analytics')
.controller('DashboardController', DashboardController);

function DashboardController(DashboardFactory, $localStorage, $rootScope) {
	var vm = this

	$rootScope.$on('list_webproperties', function (e) {
		listWebProperties();
	})

	$rootScope.$on('list_profiles', function (e) {
		listProfiles();
	})

	vm.init = function () {
		$rootScope.params.token = JSON.stringify($localStorage.access_token);
		DashboardFactory.listAccounts($rootScope.params.token).then(
			function (data) {
				$rootScope.accounts = data.data.objetoRetorno;
			});
	}

	let listWebProperties = function () {
		DashboardFactory.listWebProperties($rootScope.params).then(
			function (data) {
				$rootScope.webproperties = data.data.objetoRetorno;
			});
	}

	let listProfiles = function () {
		DashboardFactory.listProfiles($rootScope.params)
		.then(
			function (data) {
				$rootScope.profiles = data.data.objetoRetorno;
			});
	}

}