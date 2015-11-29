app.factory('MenuService', ['$http', function($http){
    var factory = {};
    factory.getMateriiUtilizator = function () {
      return $http.get('getMateriiUtilizator');
    };
  return factory;
}]);
