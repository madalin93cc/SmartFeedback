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
        $scope.value = 1;
        $scope.numeFeedback = "USO feedback saptamana 2";
    }]);


