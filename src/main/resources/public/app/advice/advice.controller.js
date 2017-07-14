angular.module('analytics').controller('AdviceController', AdviceController);

function AdviceController(AdviceFactory, $scope, $rootScope, $localStorage,
		$location) {
	let vm = this;

	$rootScope.$on('select_date', function(event) {
		let path = $location.path();
		if (path.includes('advice')) {
			vm.listAdvice();
		}
	});

	vm.listAdviceModel = {
		list1 : {},
		list2 : {},
	};

	vm.listAdvice = function() {
		AdviceFactory.listAdvice($rootScope.params).then(function(data) {
			vm.listAdviceModel = data.data.objetoRetorno;
		})
	}

	vm.init = function() {
		vm.listAdvice();
	}

}