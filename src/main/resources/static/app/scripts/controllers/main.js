'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MainCtrl', ['$scope', '$location', 'NotificationService', function ($scope, $location, NotificationService) {

    NotificationService.getActiveNotification().then(function (response) {
      $scope.notifications = response;
    });

    $scope.notificationClicked = function(notification) {
      NotificationService.setNotificationStatus(notification.id);
      $location.path(notification.url + "/" + notification.saptamana);
    };

  }]);
