"use strict";

angular.module('smartFeedbackApp')
  .factory('NotificationService', ['$http', function($http){
    return{
      getActiveNotification: function () {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/getActiveNotifications'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      setNotificationStatus: function (notifId) {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/setNotificationStatus/' + notifId
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
