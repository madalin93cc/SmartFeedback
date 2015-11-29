app.factory('LoginService', ['$http', function($http){
  var factory = {};
  factory.login = function (username, password) {
    return $http.get('login/username/' + username + "/password/" + password);
  };
  factory.logout = function (username, password) {
    return $http.get('logout');
  };
  return factory;
}]);
