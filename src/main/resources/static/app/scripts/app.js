'use strict';

/**
 * @ngdoc overview
 * @name smartFeedbackApp
 * @description
 * # smartFeedbackApp
 *
 * Main module of the application.
 */
angular.module('smartFeedbackApp', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'rzModule'
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
      .when('/completare_feedback/:feedbackId', {
        templateUrl: 'views/completare_feedback.html',
        controller: 'CompletareFeedbackCtrl'
      })
      .when('/add_feedback/:cursId/:tip', {
        templateUrl: 'views/adaugare_feedback.html',
        controller: 'AdaugareFeedbackCtrl'
      })
      .when('/statistici', {
            templateUrl: 'views/statistici.html',
            controller: 'StatisticiCtrl'
      })
      .when('/request_feedback/:cursId', {
        templateUrl: 'views/request_feedback.html',
        controller: 'RequestFeedbackCtrl'
      })
      .when('/messages',{
        templateUrl: 'views/messages.html',
        controller: 'MessagesCtrl'
      })
      .when('/signup',{
          templateUrl: 'views/signup.html',
          controller: 'SignupCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
