'use strict';

/**
 * @ngdoc function
 * @name smartFeedbackApp.controller:MessagesCtrl
 * @description
 * # MessagesCtrl
 * Controller of the smartFeedbackApp
 */
angular.module('smartFeedbackApp')
  .controller('MessagesCtrl', ['$scope', '$location', 'MessageService', function ($scope, $location, MessageService) {
    $scope.activeTab = 1;
    $scope.showSuccess = false;

    MessageService.getUsersForMessages().then(function (response) {
      $scope.users = response;
    });

    MessageService.getInbox().then(function (response) {
      $scope.inbox = response;
    });

    MessageService.getOutbox().then(function (response) {
      $scope.outbox = response;
    });

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

    $scope.sendMessage = function(){
      debugger;
      MessageService.sendMessage($scope.message).then(function(response){
        $scope.showSuccess = true;
        $scope.message= {};
      });
    };

    $scope.closeSuccess = function () {
      $scope.showSuccess = false;
      MessageService.getOutbox().then(function (response) {
        $scope.outbox = response;
      });
    }
  }]);
