'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('LoginCtrl', ['$cookies', '$interval', '$rootScope', '$scope', '$location', '$route','LoginService',
    function ($cookies, $interval, $rootScope, $scope, $location, $route, LoginService) {

      $scope.getCurrentUser = function(){
        if ($cookies.getObject('isAuthenticated')){
          var user = $cookies.getObject('isAuthenticated');
          var usern
          $scope.username = user.prenume + " " + user.nume;
          if(user.grupa) {
            $scope.username = $scope.username + " " + user.grupa;
          }
        }
      };
      $scope.getCurrentUser();

      $scope.refresh = function () {
        $scope.getCurrentUser();
      };

      $interval($scope.refresh, 1000, 10);

      $scope.login = function () {
        if ($scope.user && $scope.user.username && $scope.user.password) {
          LoginService.login($scope.user.username, $scope.user.password)
            .success(function (response) {
              if (response) {
                $cookies.remove('isAuthenticated');
                $cookies.putObject('isAuthenticated', response);
                $scope.username = response.prenume + " " + response.nume;
                if(response.grupa) {
                  $scope.username = $scope.username + " " + response.grupa;
                }
                $rootScope.isAuthenticated = true;
                $rootScope.userId = response.id;
                $location.path("#/");
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
      };

      $scope.redirectHome = function () {
          $location.path("#/");
      }

  }]);

angular.module('smartFeedbackApp')
  .run(['$cookies', '$rootScope', '$location', '$route',
  function (
    $cookies ,$rootScope, $location) {
  $rootScope.$on('$routeChangeStart', function (e) {
    if ($cookies.get('isAuthenticated')){
      $rootScope.isAuthenticated = true;
    } else {
      $location.path("/login");
    }
  });
}]);
