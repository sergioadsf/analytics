angular.module('analytics')
.directive('calendar', Calendar);

function Calendar($rootScope){
	return {
		restrict: 'E',
		link: function (scope, element, attrs) {
			
			scope.dataModel = {
				data1: {dataInit: new Date(), dataEnd: new Date()},
				compare: false,
				data2: {dataInit: "", dataEnd: ""},
			}

			scope.clickCompare = function(){
				if(scope.dataModel.compare){
					scope.dataModel.data2.dataInit = new Date();
					scope.dataModel.data2.dataEnd = new Date();
				}
			}


			$rootScope.params = {
				dateInit1: new Date(), dateEnd1: new Date()
			}

			scope.selectDate = function () {
				$rootScope.params.dateInit1 = scope.dataModel.data1.dataInit;
				$rootScope.params.dateEnd1 = scope.dataModel.data1.dataEnd;

				if(scope.dataModel.compare){
					$rootScope.params.dateInit2 = scope.dataModel.data2.dataInit;
					$rootScope.params.dateEnd2 = scope.dataModel.data2.dataEnd;
				}else {
					$rootScope.params.dateInit2 = null;
					$rootScope.params.dateEnd2 = null;	
				}

				$rootScope.$broadcast('select_date');
			}
		},
		templateUrl: 'app/partials/calendar.html'
	};
}