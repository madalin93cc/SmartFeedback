'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MainCtrl', ['$scope', '$interval', '$location', 'NotificationService', function ($scope, $interval, $location, NotificationService) {

    $scope.getNotifications = function () {
      NotificationService.getActiveNotification().then(function (response) {
        $scope.notifications = response;
      });
    };
    $scope.getNotifications();

    $scope.refresh = function(){
      $scope.getNotifications();
    };

    $interval($scope.refresh,2000);

    $scope.notificationClicked = function(notification) {
      NotificationService.setNotificationStatus(notification.id).then(function(){
        NotificationService.getActiveNotification().then(function (response) {
          $scope.notifications = response;
        });
      });
      $location.path(notification.url + "/" + notification.saptamana);
    };

  }]);
