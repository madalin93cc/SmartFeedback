'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MessagesCtrl
 * @description
 * # MessagesCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MessagesCtrl', ['$scope', '$location', function ($scope, $location) {
    $scope.activeTab = 1;

    $scope.getTabClass = function (tabId) {
      if ($scope.activeTab === tabId){
        return "active";
      } else {
        return "";
      }
    };

    $scope.getTabContentClass = function (tabContId) {
      if ($scope.activeTab === tabContId){
        return "tab-pane fade in active";
      } else {
        return "tab-pane fade";
      }
    };

    $scope.tabClicked = function (tabId) {
      if ($scope.activeTab !== tabId){
        $scope.activeTab = tabId
      }
    };
  }]);
