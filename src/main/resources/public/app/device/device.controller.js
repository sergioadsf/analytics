angular.module('analytics').controller('DeviceController', DeviceController);

function DeviceController(DeviceFactory, $scope, $rootScope, $localStorage,
		$location) {
	let vm = this;

	$rootScope.$on('select_date', function(event) {
		let path = $location.path();
		if (path.includes('device')) {
			vm.listDevice();
		}
	});

	vm.listDeviceModel = {
		list1 : {},
		list2 : {},
	};

	vm.listDevice = function() {
		DeviceFactory.listDevice($rootScope.params).then(function(data) {
			vm.listDeviceModel = data.data.objetoRetorno;
		})
	}

	vm.init = function() {
		vm.listDevice();
	}

}