angular.module('analytics')
	.directive('contasDirective', ContasDirective);

function ContasDirective($rootScope) {
	return {
		restrict: 'E',
		link: function (scope, element, attrs) {

			scope.listarWebProperties = function () {
				$rootScope.params.idAccount = null;
				if (scope.accountSelected) {
					$rootScope.params.idAccount = scope.accountSelected.id;
					$rootScope.$emit('list_webproperties');
				}
			}

			scope.listarProfiles = function () {
				$rootScope.params.idWebProperties = null;
				if (scope.webpropertySelected) {
					$rootScope.params.idWebProperty = scope.webpropertySelected.id;
					$rootScope.$emit('list_profiles');
				}
			}

			scope.selecionarProfile = function () {
				$rootScope.params.idProfile = null;
				if (scope.profileSelected) {
					$rootScope.params.idProfile = scope.profileSelected.id;
					$rootScope.$emit('select_profiles');
				}
			}
		},
		templateUrl: 'app/partials/dropdown-account.html'
	}
}