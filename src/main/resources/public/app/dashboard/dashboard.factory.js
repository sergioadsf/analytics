angular.module('analytics')
.factory('DashboardFactory', DashboardFactory);

function DashboardFactory($httpService) {

    let _listAccounts = function(token) {

        return $httpService.post(`dashboard/listAccounts`, token);
    }

    let _listWebProperties = function(params) {

        return $httpService.post(`dashboard/listWebProperties`, params);
    }

    let _listProfiles = function(params) {

        return $httpService.post(`dashboard/listProfiles`, params);
    }

    let service = {
        listAccounts: _listAccounts,
        listWebProperties: _listWebProperties,
        listProfiles: _listProfiles,
    }

    return service;
}