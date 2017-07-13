angular.module('analytics')
.controller('LoginController', LoginController);

function LoginController(LoginFactory, $location, $localStorage, $rootScope) {
	var vm = this;

	gapi.load('auth2', function() {
		gapi.auth2.init({
			client_id: '182055295159-95po4nipg71f77n0veb0dni48i3gs49n.apps.googleusercontent.com',
		});
		var GoogleAuth  = gapi.auth2.getAuthInstance();


		vm.onLogInButtonClick=function(){
			GoogleAuth.grantOfflineAccess({
				'redirect_uri': 'postmessage',
				'access_type': 'offline',
				'approval_prompt': 'force',
			}).then(offlineAccessExchangeCode => {

				const authResp = GoogleAuth.currentUser.get().getAuthResponse();
				LoginFactory.connect(offlineAccessExchangeCode).then(
					function(data){
						$localStorage.access_token = data.data.objetoRetorno;
						$rootScope.isLogado = true;
						$location.path('dashboard')
					}).catch(showError);
			});
		};
	});

	function showError(data, status){
		console.log("Erro")
	}

}
