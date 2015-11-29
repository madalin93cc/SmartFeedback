'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('LoginCtrl', ['$rootScope', '$scope', '$location', 'LoginService', function ($rootScope, $scope, $location, LoginService) {

    $scope.login = function () {
      LoginService.login($scope.user.username, $scope.user.password)
        .success(function(response){
          if (response){
            $rootScope.isAuthenticated = true;
            $location.path("#/");
          }
        });
    };

    $scope.logout = function () {
      LoginService.logout()
        .success(function(response){
          if (response){
            $rootScope.isAuthenticated = false;
            $location.path("#/login");
          }
        });
    }

  }]);

app.run(['$rootScope', '$location', function ($rootScope, $location) {
  $rootScope.$on('$routeChangeStart', function (event) {
    if (!$rootScope.isAuthenticated){
      $location.path("/login");
    }
  });
}]);
