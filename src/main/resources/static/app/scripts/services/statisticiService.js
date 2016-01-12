"use strict";

angular.module('smartFeedbackApp')
  .factory('StatisticiService', ['$http', 'myConst', '$cookies', function($http, myConst, $cookies){
    var user = $cookies.getObject('isAuthenticated');
    return{
      getNoFeedbacks: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getNoFeedbacks/' + user.id
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getMediiActivitati: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getMediiActivitati/' + user.id
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
