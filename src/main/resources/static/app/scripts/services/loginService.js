"use strict";

angular.module('smartFeedbackApp')
  .factory('LoginService', ['$http', function($http){
  var factory = {};

  factory.login = function (username, password) {
    return $http.get('http://localhost:8080/login/username/' + username + "/password/" + password);
  };
  factory.logout = function () {
    return $http.get('http://localhost:8080/logout');
  };
  return factory;
}]);
