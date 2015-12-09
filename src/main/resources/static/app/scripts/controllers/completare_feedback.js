/**
 * Created by VladC on 24-Nov-15.
 */
'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
    .controller('CompletareFeedbackCtrl', ['$scope', '$cookies', 'FeedbackService', '$routeParams', function ($scope, $cookies, FeedbackService, $routeParams) {
    $scope.feedbackId = $routeParams.feedbackId;
    //$scope.feedback = {};
    $scope.feedbackCompleted = false;

    FeedbackService.getFeedbackDetailbyId($routeParams.feedbackId).then(function (response) {
      $scope.feedbackDetails = response;
    });

    FeedbackService.getFeedback($cookies.getObject('isAuthenticated').id, $scope.feedbackId).then(function (response) {
      $scope.feedback = {
        'idFeedback' : $scope.feedbackId,
        'notaGenerala': (response.notaGenerala != null)? response.notaGenerala: 5,
        'interactiune': (response.interactiune != null)? response.interactiune: 5,
        'gradIntelegere': (response.gradIntelegere != null)? response.gradIntelegere: 5,
        'organizare': (response.organizare != null)? response.organizare: 5,
        'expunere': (response.expunere != null)? response.expunere: 5,
        'comentariu': ""
      };

      $scope.completed = response.completed;
    });

    FeedbackService.getComments($scope.feedbackId).then(function (response) {
      $scope.comments = response;
    });

    $scope.saveFeedback = function(){
      if ($scope.completed) {
        $scope.feedback.completed = true;
      } else {
        $scope.feedback.completed = false;
      }
      FeedbackService.saveFeedback($scope.feedback).then(function () {
        FeedbackService.getComments($scope.feedbackId).then(function (response) {
          $scope.comments = response;
          $scope.feedback.comentariu = "";
          $scope.completed = true;
        });
      });
    };

    $scope.chart = new CanvasJS.Chart("chartContainer", {
//            title: {
//                text: "Mobile Phones Used For",
//                fontFamily: "Verdana",
//                fontColor: "Peru",
//                fontSize: 28
//
//            },
//            credits: {
//                enabled: false
//            },
      animationEnabled: true,

      axisY: {
        tickThickness: 1,
        lineThickness: 1,
        valueFormatString: "#",
        gridThickness: 0,
        interval: 1,
        maximum: 10
      },
      axisX: {
        tickThickness: 0,
        lineThickness: 0,
        labelFontSize: 18,
        labelFontColor: "Peru"

      },
      data: [
        {
          indexLabelFontSize: 26,
          toolTipContent: "<span style='\"'color: {color};'\"'><strong>{indexLabel}</strong></span><span style='\"'font-size: 20px; color:peru '\"'><strong>{y}</strong></span>",
          indexLabelPlacement: "inside",
          indexLabelFontColor: "white",
          indexLabelFontWeight: 600,
          indexLabelFontFamily: "Verdana",
          color: "#62C9C3",
          type: "bar",
          dataPoints: [
            { y: 7.2, label: "7.2", indexLabel: "Expunerea activitatii" },
            { y: 10.0, label: "10.0", indexLabel: "Organizare" },
            { y: 8.1, label: "8.1", indexLabel: "Gradul de intelegere" },
            { y: 6.0, label: "6.0", indexLabel: "Interactiunea cu studentii" },
            { y: 8.5, label: "8.5", indexLabel: "Nota generala" }
          ]
        }
      ]
    });
    $scope.chart.render();
    }]);


