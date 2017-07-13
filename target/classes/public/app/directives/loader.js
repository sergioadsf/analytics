angular.module('analytics')
.directive("loader", function ($rootScope) {
	return function ($scope, element, attrs) {
		$scope.$on("loader_show", function () {
			$scope.showEl = true;
		});
		return $scope.$on("loader_hide", function () {
			$scope.showEl = false;
		});
	};
});