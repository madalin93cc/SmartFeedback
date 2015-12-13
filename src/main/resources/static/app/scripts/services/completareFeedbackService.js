"use strict";

angular.module('smartFeedbackApp')
  .factory('FeedbackService', ['$http',
    function($http){
      return{
        getFeedbackDetailbyId: function (id) {
          return $http({
            method: 'GET',
            url: 'http://localhost:8080/getFeedbackDetailById/' + id
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
            url: 'http://localhost:8080/getFeedback/' + userId + "/" + feedbackId
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
            url: 'http://localhost:8080/getCommentsForFeedback/' + feedbackId
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
            url: 'http://localhost:8080/getStatistics/' + feedbackId
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
            url: 'http://localhost:8080/saveFeedback/',
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
            url: 'http://localhost:8080/getAdaugareFeedbackDetails/' + activityId
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
            url: 'http://localhost:8080/addFeedback/' + activityId + "/" + week
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
            url: 'http://localhost:8080/requestFeedback/' + activityId + "/" + week
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        }
      };
    }]);
