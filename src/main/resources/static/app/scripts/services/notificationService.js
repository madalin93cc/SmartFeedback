"use strict";

angular.module('smartFeedbackApp')
  .factory('NotificationService', ['$http', 'myConst', '$cookies', function($http, myConst, $cookies){
    var user = $cookies.getObject('isAuthenticated');
    return{
      getActiveNotification: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getActiveNotifications/' + user.id
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
