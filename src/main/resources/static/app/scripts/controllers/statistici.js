'use strict';

/**
 * Created by VladC on 13-Dec-15.
 */

angular.module('smartFeedbackApp')
    .controller('StatisticiCtrl', ['$scope', '$cookies', 'StatisticiService',function($scope, $cookies, StatisticiService) {
    $scope.note = [];
    $scope.user = $cookies.getObject('isAuthenticated');
    StatisticiService.getMediiActivitati().then(function (response) {
      $scope.mediiActivitati = response;
      angular.forEach($scope.mediiActivitati, function (value) {
        $scope.note.push({ y : value.materie.nume, a : Math.round(value.medieNote * 100) / 100});
      });
      $scope.bar = Morris.Bar({
        element: 'bar-example',
        data: $scope.note,
        xkey: 'y',
        parsetime: false,
        ykeys: ['a'],
        ymax: 10,
        labels: ['Nota']
      });
    });

    if ($scope.user.userType === 'PROFESOR') {

      $scope.chart = new CanvasJS.Chart("chartContainer", {
        animationEnabled: true,
        legend: {
          verticalAlign: "bottom",
          horizontalAlign: "center"
        },
        data: [
          {
            indexLabelFontSize: 20,
            indexLabelFontFamily: "Monospace",
            indexLabelFontColor: "darkgrey",
            indexLabelLineColor: "darkgrey",
            indexLabelPlacement: "outside",
            type: "pie",
            showInLegend: true,
            toolTipContent: "{y} - <strong>#percent%</strong>",
            dataPoints: [
              {y: 60, legendText: "SO II", indexLabel: "Sisteme de operare II"},
              {y: 40, legendText: "CPL", indexLabel: "Compilatoare"},
              {y: 85, legendText: "PR", exploded: true, indexLabel: "Proiectarea retelelor"},
              {y: 23, legendText: "MPS", indexLabel: "Managementul proiectelor software"},
              {y: 30, legendText: "IOC", indexLabel: "Interactiunea om - calculator"}
            ]
          }
        ]
      });
      //$scope.chart.render();
      $scope.materii = [];

      $scope.feedbackRez = [
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
      ];

      $scope.changeMaterie = function () {
        $scope.feedbacks = [];
        angular.forEach($scope.nrFeedbacks, function (value) {
          if (value.materie.id === $scope.materie.id) {
            $scope.feedbacks = value.feedbackPeSaptamanaDTOs;
            var i = 0;
            angular.forEach($scope.feedbacks, function (value) {
              $scope.feedbackRez[i++] = value.feedbacks;
            });

            $scope.chart = new CanvasJS.Chart("chartLine", {
              theme: "theme2",
              animationEnabled: true,
              axisX: {},
              axisY: {},
              data: [
                {
                  type: "line",
                  dataPoints: [
                    {x: 1, y: $scope.feedbackRez[0]},
                    {x: 2, y: $scope.feedbackRez[1]},
                    {x: 3, y: $scope.feedbackRez[2]},
                    {x: 4, y: $scope.feedbackRez[3]},
                    {x: 5, y: $scope.feedbackRez[4]},
                    {x: 6, y: $scope.feedbackRez[5]},
                    {x: 7, y: $scope.feedbackRez[6]},
                    {x: 8, y: $scope.feedbackRez[7]},
                    {x: 9, y: $scope.feedbackRez[8]},
                    {x: 10, y: $scope.feedbackRez[9]},
                    {x: 11, y: $scope.feedbackRez[10]},
                    {x: 12, y: $scope.feedbackRez[11]},
                    {x: 13, y: $scope.feedbackRez[12]},
                    {x: 14, y: $scope.feedbackRez[13]}
                  ]
                }
              ]
            });
            $scope.chart.render();
          }
        });
      };

      StatisticiService.getNoFeedbacks().then(function (response) {
        $scope.nrFeedbacks = response;
        angular.forEach($scope.nrFeedbacks, function (value) {
          $scope.materii.push(value.materie);
        });

        $scope.chart = new CanvasJS.Chart("chartLine", {
          theme: "theme2",
          animationEnabled: true,
          axisX: {},
          axisY: {
            includeZero: false

          },
          data: [
            {
              type: "line",
              dataPoints: [
                {x: 1, y: $scope.feedbackRez[0]},
                {x: 2, y: $scope.feedbackRez[1]},
                {x: 3, y: $scope.feedbackRez[2]},
                {x: 4, y: $scope.feedbackRez[3]},
                {x: 5, y: $scope.feedbackRez[4]},
                {x: 6, y: $scope.feedbackRez[5]},
                {x: 7, y: $scope.feedbackRez[6]},
                {x: 8, y: $scope.feedbackRez[7]},
                {x: 9, y: $scope.feedbackRez[8]},
                {x: 10, y: $scope.feedbackRez[9]},
                {x: 11, y: $scope.feedbackRez[10]},
                {x: 12, y: $scope.feedbackRez[11]},
                {x: 13, y: $scope.feedbackRez[12]},
                {x: 14, y: $scope.feedbackRez[13]}
              ]
            }
          ]
        });
        $scope.chart.render();
      });
    }
}]);
