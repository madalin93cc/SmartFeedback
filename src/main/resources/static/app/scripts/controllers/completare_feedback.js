/**
 * Created by VladC on 24-Nov-15.
 */
'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
    .controller('CompletareFeedbackCtrl', ['$scope', 'FeedbackService', '$routeParams', function ($scope, FeedbackService, $routeParams) {

    FeedbackService.getFeedbackDetailbyId($routeParams.feedbackId).then(function (response) {
      $scope.feedbackDetails = response;
    });

    $scope.saveFeedback = function(){
      FeedbackService.saveFeedback($scope.feedback).then(function (response) {});
    };

    $scope.feedback = {
      'notaGenerala': 5,
      'interactiune': 5,
      'gradIntelegere': 5,
      'organizare': 5,
      'expunere': 5,
      'comentariu': ""
    };
        $scope.value1 = 1;
        $scope.value2 = 1;
        $scope.value3 = 1;
        $scope.value4 = 1;
        $scope.value5 = 1;
    }]);


