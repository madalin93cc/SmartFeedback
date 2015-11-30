'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('LoginCtrl', ['$route', '$cookies', '$rootScope', '$scope', '$location', 'LoginService',
    function ($route, $cookies, $rootScope, $scope, $location, LoginService) {

    $scope.username = "Ion";
    $scope.login = function () {
      if ($scope.user && $scope.user.username && $scope.user.password) {
        LoginService.login($scope.user.username, $scope.user.password)
          .success(function (response) {
            if (response) {
              $cookies.put('isAuthenticated', $scope.user);
              $rootScope.isAuthenticated = true;
              LoginService.user = response;
              $location.path("#/");
              $route.reload();
            }
          });
      }
    };

    $scope.logout = function () {
      LoginService.logout()
        .success(function(response){
          if (response){
            $rootScope.isAuthenticated = false;
            $cookies.remove('isAuthenticated');
            $location.path("#/login");
          }
        });
    }

  }]);

app.run(['$cookies', '$rootScope', '$location',
  function (
    $cookies ,$rootScope, $location) {
  $rootScope.$on('$routeChangeStart', function (event) {
    if ($cookies.get('isAuthenticated')){
      $rootScope.isAuthenticated = true;
    } else {
      $location.path("/login");
    }
  });
}]);
