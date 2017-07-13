angular.module('analytics')
.directive('panelForm', PanelForm);

function PanelForm(){
	return {
		restrict: 'E',
		transclude: true,
		scope: {
			titulo: "@",
			mensagem: "="
		},
		link: function(scope){
			scope.limpar = function(){
				scope.$emit('form_clear');
			}

			scope.salvar = function(){
				scope.$emit('form_save');
			}

			scope.voltar = function() {
				history.back();
			}
		},
		templateUrl: 'app/partials/panel.html'
	}
}