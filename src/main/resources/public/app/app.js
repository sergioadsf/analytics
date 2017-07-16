angular.module(
		'analytics',
		[ 'ui.router', 'ngAnimate', 'ui.bootstrap', 'ngResource',
				'directive.g+signin' ]).config(config);

function config($stateProvider, $urlRouterProvider, $locationProvider) {

	$urlRouterProvider.otherwise('/');

	// $httpProvider.interceptors.push('httpInterceptor');

	$stateProvider.state('login', {
		url : '/',
		templateUrl : 'app/login/login.html',
		controller : 'LoginController',
		controllerAs : 'vm'
	})

	.state('dashboard', {
		url : '/dashboard',
		templateUrl : 'app/dashboard/dashboard.html',
		controller : 'DashboardController',
		controllerAs : 'vm'
	})

	.state('city', {
		url : '/city',
		templateUrl : 'app/city/city.html',
		controller : 'CityController',
		controllerAs : 'vm'
	})

	.state('device', {
		url : '/device',
		templateUrl : 'app/device/device.html',
		controller : 'DeviceController',
		controllerAs : 'vm'
	})

	.state('visit', {
		url : '/visit',
		templateUrl : 'app/visit/visit.html',
		controller : 'VisitController',
		controllerAs : 'vm'
	})

	.state('referTraffic', {
		url : '/referTraffic',
		templateUrl : 'app/referTraffic/referTraffic.html',
		controller : 'ReferTrafficController',
		controllerAs : 'vm'
	})

	.state('page', {
		url : '/page',
		templateUrl : 'app/page/page.html',
		controller : 'PageController',
		controllerAs : 'vm'
	})

	.state('acqChannel', {
		url : '/acqChannel',
		templateUrl : 'app/acqChannel/acqChannel.html',
		controller : 'AcqChannelController',
		controllerAs : 'vm'
	})

	// $locationProvider.html5Mode(true);
}
