"use strict";

angular.module('smartFeedbackApp')
  .factory('MenuService', ['$http', 'myConst', '$cookies',
    function($http, myConst, $cookies){
      var user = $cookies.getObject('isAuthenticated');
      return{
        getMateriiUtilizator: function () {
          return $http({
            method: 'GET',
            url: myConst.host + '/getMateriiUtilizator/' + user.id
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            return response;
          });
        }
      };
}]);
