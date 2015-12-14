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
      NotificationService.setNotificationStatus(notification.id).then(function(){
        NotificationService.getActiveNotification().then(function (response) {
          $scope.notifications = response;
        });
      });
      $location.path(notification.url + "/" + notification.saptamana);
    };

    //Morris.Line({
    //  element: 'line-example',
    //  data: [
    //    { y: 'S 1', a: 40, b: 90, c: 50, d:30},
    //    { y: 'S 2', a: 75,  b: 65, c: 80, d:80},
    //    { y: 'S 3', a: 50,  b: 40, c: 90, d:20},
    //    { y: 'S 4', a: 75,  b: 65, c: 100, d:90},
    //    { y: 'S 5', a: 50,  b: 40, c: 100, d:10},
    //    { y: 'S 6', a: 75,  b: 65, c: 80, d:70},
    //    { y: 'S 7', a: 100, b: 90, c: 10, d:30}
    //  ],
    //  xkey: 'y',
    //  ykeys: ['a', 'b', 'c', 'd'],
    //  labels: ['Materie A', 'Materie B', 'Materie C', 'Materie D'],
    //  parseTime: false
    //});

    //Morris.Donut({
    //  element: 'donut-example',
    //  data: [
    //    {label: "SO II", value: 10},
    //    {label: "CPL", value: 10},
    //    {label: "PR", value: 20},
    //    {label: "MPS", value: 40},
    //    {label: "IOC", value: 20}
    //  ]
    //});

  }]);
