angular.module('analytics')
.config(function ($httpProvider) {
	$httpProvider.interceptors.push('httpInterceptor');
});