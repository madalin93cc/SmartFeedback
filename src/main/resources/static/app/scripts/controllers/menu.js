'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MenuCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MenuCtrl', ['$scope', '$location', 'MenuService', function ($scope, $location, MenuService) {
    MenuService.getMateriiUtilizator().then(function(response){
      $scope.cursuri = response;
    });

    $scope.viewFeedback = function (id) {
      $location.path("/completare_feedback/" + id);
    };

    $scope.addFeedback = function (id) {
      $location.path("/add_feedback/" + id);
    }
  }]);
