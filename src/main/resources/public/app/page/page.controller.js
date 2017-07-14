angular.module('analytics').controller('PageController', PageController);

function PageController(PageFactory, $scope, $rootScope, $localStorage,
		$location) {
	let vm = this;

	$rootScope.$on('select_date', function(event) {
		let path = $location.path();
		if (path.includes('page')) {
			vm.listPage();
		}
	});

	vm.listPageModel = {
		list1 : {},
		list2 : {},
	};

	vm.listPage = function() {
		PageFactory.listPage($rootScope.params).then(function(data) {
			vm.listPageModel = data.data.objetoRetorno;
		})
	}

	vm.init = function() {
		vm.listPage();
	}

}