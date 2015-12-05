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
    .controller('CompletareFeedbackCtrl', ['$scope', function ($scope) {
        $scope.value1 = 1;
        $scope.value2 = 1;
        $scope.value3 = 1;
        $scope.value4 = 1;
        $scope.value5 = 1;
        $scope.numeFeedback = "USO feedback saptamana 2";
    }]);


