'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:AdaugareFeedbackCtrl
 * @description
 * # AdaugareFeedbackCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('AdaugareFeedbackCtrl', ['$scope', '$location', '$routeParams', function ($scope, $location, $routeParams) {
    $scope.cursId = $routeParams.cursId;
  }]);
