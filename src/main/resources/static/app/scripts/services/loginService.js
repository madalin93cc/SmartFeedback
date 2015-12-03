app.factory('LoginService', ['$http', function($http){
  var factory = {};
  var user = {}
  factory.setUser = function(data) {
    user = data;
  };
  factory.getUser = function() {
    return user;
  };

  factory.login = function (username, password) {
    return $http.get('http://localhost:8080/login/username/' + username + "/password/" + password);
  };
  factory.logout = function (username, password) {
    return $http.get('http://localhost:8080/logout');
  };
  return factory;
}]);
