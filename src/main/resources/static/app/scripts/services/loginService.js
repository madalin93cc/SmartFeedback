"use strict";

angular.module('smartFeedbackApp')
  .factory('LoginService', ['$http', 'myConst',  function($http, myConst){
  var factory = {};

  factory.login = function (username, password) {
    return $http.get(myConst.host + '/login/username/' + username + "/password/" + password);
  };
  factory.logout = function () {
    return $http.get(myConst.host + '/logout');
  };
  return factory;
}]);
