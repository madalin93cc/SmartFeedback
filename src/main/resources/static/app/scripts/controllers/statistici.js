/**
 * Created by VladC on 13-Dec-15.
 */

angular.module('smartFeedbackApp')
    .controller('StatisticiCtrl', ['$scope', function($scope) {
    $scope.greeting = 'Hola!';
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
                        { x: new Date(2012, 00, 1), y: 450 },
                        { x: new Date(2012, 01, 1), y: 414},
                        { x: new Date(2012, 02, 1), y: 520, indexLabel: "highest",markerColor: "red", markerType: "triangle"},
                        { x: new Date(2012, 03, 1), y: 460 },
                        { x: new Date(2012, 04, 1), y: 450 },
                        { x: new Date(2012, 05, 1), y: 500 },
                        { x: new Date(2012, 06, 1), y: 480 },
                        { x: new Date(2012, 07, 1), y: 480 },
                        { x: new Date(2012, 08, 1), y: 410 , indexLabel: "lowest",markerColor: "DarkSlateGrey", markerType: "cross"},
                        { x: new Date(2012, 09, 1), y: 500 },
                        { x: new Date(2012, 10, 1), y: 480 },
                        { x: new Date(2012, 11, 1), y: 510 }
                    ]
                }
            ]
        });
        $scope.chart.render();

}]);