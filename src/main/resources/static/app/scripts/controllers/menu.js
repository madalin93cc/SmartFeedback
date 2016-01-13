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

    $scope.getMaterii = function() {
      MenuService.getMateriiUtilizator($cookies.getObject('isAuthenticated').id).then(function(response){
        $scope.cursuri = response;
      });
    };

    $scope.getMaterii();

    $scope.viewFeedback = function (id) {
      $location.path("/completare_feedback/" + id);
    };

    $scope.addFeedback = function (id) {
      $location.path("/add_feedback/" + id + "/" + 0);
    };

    $scope.requestFeedback = function (id) {
      $location.path("/request_feedback/" + id);
    };
  }]);
