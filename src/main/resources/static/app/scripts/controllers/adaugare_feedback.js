'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:AdaugareFeedbackCtrl
 * @description
 * # AdaugareFeedbackCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('AdaugareFeedbackCtrl', ['$scope', '$location', '$routeParams', 'FeedbackService', function ($scope, $location, $routeParams, FeedbackService) {
    $scope.cursId = $routeParams.cursId;
    $scope.activityName = null;
    $scope.weeks = [];
    $scope.showSuccess = false;

    FeedbackService.getDetailsForAdd($scope.cursId).then(function(response){
      $scope.activityName = response.nume;
      $scope.weeks = response.availableWeeks;
    });

    $scope.createFeedback = function() {
      FeedbackService.createFeedback($scope.cursId, $scope.selectedWeek).then(function () {
        $scope.showSuccess = true;
      });
    };

    $scope.closeSuccess = function () {
      $scope.showSuccess = false;
      $location.path("/");
    };

  }]);
