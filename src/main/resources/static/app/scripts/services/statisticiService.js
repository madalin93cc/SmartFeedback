"use strict";

angular.module('smartFeedbackApp')
  .factory('StatisticiService', ['$http', function($http){
    return{
      getNoFeedbacks: function () {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/getNoFeedbacks'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getMediiActivitati: function () {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/getMediiActivitati'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
