app.factory('FeedbackService', ['$http',
    function($http){
      return{
        getFeedbackDetailbyId: function (id) {
          return $http({
            method: 'GET',
            url: 'http://localhost:8080/getFeedbackDetailById/' + id
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        },
        saveFeedback: function (feedback) {
          return $http({
            method: 'POST',
            url: 'http://localhost:8080/saveFeedback/',
            data: feedback
          }).then(function successCallback(response) {
            return response.data;
          }, function errorCallback(response) {
            console.log('error');
            return response;
          });
        }
      }
    }]);
