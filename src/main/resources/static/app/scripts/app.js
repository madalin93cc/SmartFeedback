'use strict';

/**
 * @ngdoc overview
 * @name smartFeedbackApp
 * @description
 * # smartFeedbackApp
 *
 * Main module of the application.
 */
var app = angular
  .module('smartFeedbackApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .when('/completare_feedback', {
        templateUrl: 'views/completare_feedback.html',
        controller: 'MainCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
