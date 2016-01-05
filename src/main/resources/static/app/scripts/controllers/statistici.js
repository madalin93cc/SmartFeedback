'use strict';

/**
 * Created by VladC on 13-Dec-15.
 */

angular.module('smartFeedbackApp')
    .controller('StatisticiCtrl', ['$scope', 'StatisticiService',function($scope, StatisticiService) {
    $scope.note = [];

    StatisticiService.getMediiActivitati().then(function (response) {
      debugger;
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
      $scope.chart = new CanvasJS.Chart("chartContainer", {
          animationEnabled: true,
          legend:{
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
                      {  y: 60, legendText:"SO II", indexLabel: "Sisteme de operare II" },
                      {  y: 40, legendText:"CPL", indexLabel: "Compilatoare" },
                      {  y: 85, legendText:"PR",exploded: true, indexLabel: "Proiectarea retelelor" },
                      {  y: 23, legendText:"MPS" , indexLabel: "Managementul proiectelor software"},
                      {  y: 30, legendText:"IOC", indexLabel: "Interactiunea om - calculator" }
                  ]
              }
          ]
      });
      $scope.chart.render();

      $scope.chart = new CanvasJS.Chart("chartLine", {
          theme: "theme2",
          animationEnabled: true,
          axisX: {
              valueFormatString: "MMM",
              interval:1,
              intervalType: "month"

          },
          axisY:{
              includeZero: false

          },
          data: [
              {
                  type: "line",
                  //lineThickness: 3,
                  dataPoints: [
                      { x: new Date(2012, 0, 1), y: 450 },
                      { x: new Date(2012, 1, 1), y: 414},
                      { x: new Date(2012, 2, 1), y: 520, indexLabel: "highest",markerColor: "red", markerType: "triangle"},
                      { x: new Date(2012, 3, 1), y: 460 },
                      { x: new Date(2012, 4, 1), y: 450 },
                      { x: new Date(2012, 5, 1), y: 500 },
                      { x: new Date(2012, 6, 1), y: 480 },
                      { x: new Date(2012, 7, 1), y: 480 },
                      { x: new Date(2012, 8, 1), y: 410 , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross"},
                      { x: new Date(2012, 9, 1), y: 500 },
                      { x: new Date(2012, 10, 1), y: 480 },
                      { x: new Date(2012, 11, 1), y: 510 }
                  ]
              }
          ]
      });
      $scope.chart.render();

}]);
