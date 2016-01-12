"use strict";

angular.module('smartFeedbackApp')
  .factory('MessageService', ['$http', 'myConst', '$cookies', function($http, myConst, $cookies){
    var user = $cookies.getObject('isAuthenticated');
    return{
      getUsersForMessages: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getUsersFormMessages/' + user.id
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getInbox: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getInbox/' + user.id
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getOutbox: function () {
        return $http({
          method: 'GET',
          url: myConst.host + '/getOutbox/' + user.id
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      sendMessage: function (message) {
        return $http({
          method: 'POST',
          url: myConst.host + '/sendMessage/' + user.id,
          data: message
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      changeSeen: function (messageId, change) {
        return $http({
          method: 'GET',
          url: myConst.host + '/changeSeen/' + messageId + "/" + change
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
