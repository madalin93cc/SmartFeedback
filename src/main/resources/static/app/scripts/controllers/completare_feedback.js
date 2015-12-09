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
    $scope.user = $cookies.getObject('isAuthenticated');
    $scope.isStudent = $scope.user.userType === "STUDENT";
    $scope.feedback = {
      'idFeedback': $scope.feedbackId,
      'comentariu': ""
    };
    $scope.completed = false;
    FeedbackService.getFeedbackDetailbyId($routeParams.feedbackId).then(function (response) {
      $scope.feedbackDetails = response;
    });

    if ($scope.isStudent) {
      FeedbackService.getFeedback($scope.user.id, $scope.feedbackId).then(function (response) {
        $scope.feedback = {
          'idFeedback': $scope.feedbackId,
          'notaGenerala': (response.notaGenerala != null) ? response.notaGenerala : 5,
          'interactiune': (response.interactiune != null) ? response.interactiune : 5,
          'gradIntelegere': (response.gradIntelegere != null) ? response.gradIntelegere : 5,
          'organizare': (response.organizare != null) ? response.organizare : 5,
          'expunere': (response.expunere != null) ? response.expunere : 5,
          'comentariu': ""
        };
        $scope.completed = response.completed;
      });
    }

    $scope.loadStat = function(){
      FeedbackService.loadStatistics($scope.feedbackId).then(function (response) {
        if (response !== "") {
          $scope.nrFeedbacks = response.numarFeedbackuri;
          $scope.chart = new CanvasJS.Chart("chartContainer", {
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
                  {
                    y: response.expunereMedie,
                    label: response.expunereMedie.toString(),
                    indexLabel: "Expunerea activitatii"
                  },
                  {y: response.organizareMedie, label: response.organizareMedie.toString(), indexLabel: "Organizare"},
                  {
                    y: response.gradIntelegereMedie,
                    label: response.gradIntelegereMedie.toString(),
                    indexLabel: "Gradul de intelegere"
                  },
                  {
                    y: response.interactiuneMedie,
                    label: response.interactiuneMedie.toString(),
                    indexLabel: "Interactiunea cu studentii"
                  },
                  {
                    y: response.notaGeneralaMedie,
                    label: response.notaGeneralaMedie.toString(),
                    indexLabel: "Nota generala"
                  }
                ]
              }
            ]
          });
          $scope.chart.render();
        } else {
          $scope.nrFeedbacks = 0;
          $scope.chart = new CanvasJS.Chart("chartContainer", {
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
                  {
                    y: 0,
                    label: "",
                    indexLabel: "Expunerea activitatii"
                  },
                  {y: 0, label: "", indexLabel: "Organizare"},
                  {
                    y: 0,
                    label: "",
                    indexLabel: "Gradul de intelegere"
                  },
                  {
                    y: 0,
                    label: "",
                    indexLabel: "Interactiunea cu studentii"
                  },
                  {
                    y: 0,
                    label: "",
                    indexLabel: "Nota generala"
                  }
                ]
              }
            ]
          });
          $scope.chart.render();
        }
      });
    };

    $scope.loadStat();

    FeedbackService.getComments($scope.feedbackId).then(function (response) {
      $scope.comments = response;
    });

    $scope.saveFeedback = function(){
      if (!$scope.isStudent){
        $scope.feedback.completed = true;
      } else if ($scope.completed) {
        $scope.feedback.completed = true;
      } else {
        $scope.feedback.completed = false;
      }
      FeedbackService.saveFeedback($scope.feedback).then(function () {
        FeedbackService.getComments($scope.feedbackId).then(function (response) {
          $scope.comments = response;
          $scope.feedback.comentariu = "";
          $scope.completed = true;
          $scope.loadStat();
        });
      });
    };

    $scope.checkTrimiteEnabled = function(){
      if ($scope.completed){
        if ($scope.feedback.comentariu !== "" && $scope.feedback.comentariu !== undefined){
          return false;
        } else {
          return true;
        }
      } else {
        return false;
      }
    }
    }]);


