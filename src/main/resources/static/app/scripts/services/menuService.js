"use strict";

angular.module('smartFeedbackApp')
  .factory('MenuService', ['$http', function($http){
  return{
    getMateriiUtilizator: function () {
      return $http({
        method: 'GET',
        url: 'http://localhost:8080/getMateriiUtilizator'
      }).then(function successCallback(response) {
        return response.data;
      }, function errorCallback(response) {
        return response;
      });
    }
  };
}]);
