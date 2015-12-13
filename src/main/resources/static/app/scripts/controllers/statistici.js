'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:StatisticiCtrl
 * @description
 * # StatisticiCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
    .controller('StatisticiCtrl', ['$scope', function($scope) {
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
}]);
