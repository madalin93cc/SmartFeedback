"use strict";

angular.module('smartFeedbackApp')
  .factory('StatisticiService', ['$http', 'myConst', function($http, myConst){
    return{
      getNoFeedbacks: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getNoFeedbacks'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getMediiActivitati: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getMediiActivitati'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
