"use strict";

angular.module('smartFeedbackApp')
  .factory('MessageService', ['$http', function($http){
    return{
      getUsersForMessages: function () {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/getUsersFormMessages'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getInbox: function () {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/getInbox'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      getOutbox: function () {
        return $http({
          method: 'GET',
          url: 'http://localhost:8080/getOutbox'
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      },
      sendMessage: function (message) {
        return $http({
          method: 'POST',
          url: 'http://localhost:8080/sendMessage/',
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
          url: 'http://localhost:8080/changeSeen/' + messageId + "/" + change,
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
