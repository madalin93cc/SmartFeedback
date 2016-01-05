"use strict";

angular.module('smartFeedbackApp')
  .factory('MenuService', ['$http', 'myConst', function($http, myConst){
  return{
    getMateriiUtilizator: function () {
      return $http({
        method: 'GET',
        url: myConst.host + '/getMateriiUtilizator'
      }).then(function successCallback(response) {
        return response.data;
      }, function errorCallback(response) {
        return response;
      });
    }
  };
}]);
