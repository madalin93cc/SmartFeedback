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
          url: 'http://localhost:8080/sendMessage',
          date: message
        }).then(function successCallback(response) {
          return response.data;
        }, function errorCallback(response) {
          return response;
        });
      }
    };
  }]);
