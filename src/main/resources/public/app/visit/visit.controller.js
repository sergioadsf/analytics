angular.module('analytics').controller('VisitController', VisitController);

function VisitController(VisitFactory, $scope, $rootScope, $localStorage,
		$location) {
	let vm = this;

	$rootScope.$on('select_date', function(event) {
		let path = $location.path();
		if (path.includes('visit')) {
			vm.listVisit();
		}
	});

	vm.listVisitModel = {
		list1 : {},
		list2 : {},
	};

	vm.listVisit = function() {
		VisitFactory.listVisit($rootScope.params).then(function(data) {
			vm.listVisitModel = data.data.objetoRetorno;
		})
	}

	vm.init = function() {
		vm.listVisit();
	}

}