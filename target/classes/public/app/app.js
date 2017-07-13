angular.module('analytics', [
	'ui.router',
	'ngAnimate',
	'ui.bootstrap',
	'ngResource',
	'directive.g+signin'
	]).config(config);

function config ($stateProvider, $urlRouterProvider, $locationProvider){

	$urlRouterProvider.otherwise('/');

	//$httpProvider.interceptors.push('httpInterceptor');

	$stateProvider
	.state('login', {
		url: '/',
		templateUrl: 'app/login/login.html',
		controller: 'LoginController',
		controllerAs: 'vm'
	})	

	.state('dashboard', {
		url: '/dashboard',
		templateUrl: 'app/dashboard/dashboard.html',
		controller: 'DashboardController',
		controllerAs: 'vm'
	})

	.state('city', {
		url: '/city',
		templateUrl: 'app/city/city.html',
		controller: 'CityController',
		controllerAs: 'vm'
	})


	//$locationProvider.html5Mode(true);
}



