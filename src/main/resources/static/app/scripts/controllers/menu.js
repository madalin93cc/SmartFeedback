'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MenuCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MenuCtrl', ['$cookies', '$scope', '$location', 'MenuService', function ($cookies, $scope, $location, MenuService) {
    $scope.userType = $cookies.getObject('isAuthenticated').userType;

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
