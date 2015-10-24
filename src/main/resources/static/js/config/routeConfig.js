app.config(function($routeProvider){
    $routeProvider
        .when('/',{
            templateUrl: '../../views/login.html',
            controller: 'homeController'
        })
        // add routes here
        .when('/page1', {
            templateUrl: '../../views/page1.html',
            controller: 'homeController'
        })
        .when('/page2', {
            templateUrl: '../../views/page2.html',
            controller: 'homeController'
        })
        .otherwise({
            redirectTo: '/'
        });
});