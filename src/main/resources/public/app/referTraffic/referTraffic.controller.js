angular.module('analytics').controller('ReferTrafficController', ReferTrafficController);

function ReferTrafficController(ReferTrafficFactory, $scope, $rootScope, $localStorage,
		$location) {
	let vm = this;

	$rootScope.$on('select_date', function(event) {
		let path = $location.path();
		if (path.includes('referTraffic')) {
			vm.listReferTraffic();
		}
	});

	vm.listReferTrafficModel = {
		list1 : {},
		list2 : {},
	};

	vm.listReferTraffic = function() {
		ReferTrafficFactory.listReferTraffic($rootScope.params).then(function(data) {
			vm.listReferTrafficModel = data.data.objetoRetorno;
		})
	}

	vm.init = function() {
		vm.listReferTraffic();
	}

}