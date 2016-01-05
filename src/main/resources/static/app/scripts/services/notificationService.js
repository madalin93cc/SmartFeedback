"use strict";

angular.module('smartFeedbackApp')
  .factory('NotificationService', ['$http', 'myConst', function($http, myConst){
    return{
      getActiveNotification: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getActiveNotifications'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      setNotificationStatus: function (notifId) {
        return $http({
          method: 'GET',
          url: myConst.host + '/setNotificationStatus/' + notifId
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
