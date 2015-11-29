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
    return $http.get('login/username/' + username + "/password/" + password);
  };
  factory.logout = function (username, password) {
    return $http.get('logout');
  };
  return factory;
}]);
