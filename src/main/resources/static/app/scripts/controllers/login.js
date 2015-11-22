'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('LoginCtrl', ['$rootScope', '$scope', '$location', function ($rootScope, $scope, $location) {

    $scope.login = function () {
      $rootScope.isAuthenticated = true;
      $location.path("#/");
    }

    $scope.logout = function () {
      $rootScope.isAuthenticated = false;
    }

  }]);

app.run(['$rootScope', '$location', function ($rootScope, $location) {
  $rootScope.$on('$routeChangeStart', function (event) {
    if (!$rootScope.isAuthenticated){
      $location.path("/login");
    }
  });
}]);
