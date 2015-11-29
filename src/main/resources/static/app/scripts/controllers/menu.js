'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MenuCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MenuCtrl', ['$scope', 'MenuService', function ($scope, MenuService) {
    MenuService.getMateriiUtilizator()
      .success(function (response) {
        $scope.cursuri = response;
      });
  }]);