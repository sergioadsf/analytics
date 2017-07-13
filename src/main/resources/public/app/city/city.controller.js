angular.module('analytics')
.controller('CityController', CityController);

function CityController(CityFactory, $scope, $rootScope, $localStorage, $location){
	let vm = this;

	$rootScope.$on('select_date', function(event){
		let path = $location.path();
		if(path.includes('city')){
			vm.listCity();
		}
	});

	vm.listCityModel = {
		list1: {},
		list2: {},
	};

	vm.listCity = function(){
		CityFactory.listCity($rootScope.params)
		.then(function(data){
			vm.listCityModel = data.data.objetoRetorno;
		})
	}

	vm.init = function(){
		vm.listCity();
	}

}