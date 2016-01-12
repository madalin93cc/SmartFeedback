"use strict";

angular.module('smartFeedbackApp')
  .factory('FeedbackService', ['$http', 'myConst', '$cookies',
    function($http, myConst, $cookies){
      var user = $cookies.getObject('isAuthenticated');
      return{
        getFeedbackDetailbyId: function (id) {
          return $http({
            method: 'GET',
            url: myConst.host + '/getFeedbackDetailById/' + id
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        getFeedback: function (userId, feedbackId) {
          return $http({
            method: 'GET',
            url: myConst.host + '/getFeedback/' + userId + "/" + feedbackId
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        getComments: function (feedbackId) {
          return $http({
            method: 'GET',
            url: myConst.host + '/getCommentsForFeedback/' + feedbackId
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        loadStatistics: function (feedbackId) {
          return $http({
            method: 'GET',
            url: myConst.host + '/getStatistics/' + feedbackId
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        saveFeedback: function (feedback) {
          return $http({
            method: 'POST',
            url: myConst.host + '/saveFeedback/' + user.id,
            data: feedback
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
      //  adaugare feedback
        getDetailsForAdd: function (activityId) {
          return $http({
            method: 'GET',
            url: myConst.host + '/getAdaugareFeedbackDetails/' + activityId
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        createFeedback: function (activityId, week) {
          return $http({
            method: 'GET',
            url: myConst.host + '/addFeedback/' + activityId + "/" + week
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        requestFeedback: function (activityId, week) {
          return $http({
            method: 'GET',
            url: myConst.host + '/requestFeedback/' + activityId + "/" + week
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        }
      };
    }]);
