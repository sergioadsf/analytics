angular.module('analytics').controller('AcqChannelController',
		AcqChannelController);

function AcqChannelController(AcqChannelFactory, $scope, $rootScope,
		$localStorage, $location) {
	let vm = this;

	$rootScope.$on('select_date', function(event) {
		let path = $location.path();
		if (path.includes('acqChannel')) {
			vm.listAcqChannel();
		}
	});

	vm.listAcqChannelModel = {
		list1 : {},
		list2 : {},
	};

	vm.listAcqChannel = function() {
		AcqChannelFactory.listAcqChannel($rootScope.params).then(
				function(data) {
					vm.listAcqChannelModel = data.data.objetoRetorno;
				})
	}

	vm.init = function() {
		vm.listAcqChannel();
	}

}