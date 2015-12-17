/**
 * Created by VladC on 16-Dec-15.
 */

angular.module('smartFeedbackApp')
    .controller('SignupCtrl', ['$scope', function($scope) {
        angular.element(document).ready(function () {
            $('#divAnul').hide();
            $('#divGrupa').hide();
            $('#specializare').hide();
            $('#profesor').click(function () {
                var $this = $(this);
                if ($this.is(':checked')) {
                    $('#divAnul').hide();
                    $('#seria').hide();
                    $('#divGrupa').hide();
                    $('#specializare').hide();
                }
            });
            $('#student').click(function () {
                var $this = $(this);
                if ($this.is(':checked')) {
                    $('#divAnul').show();
                    $('#seria').show();
                    $('#divGrupa').show();
                    $('#specializare').show();
                }
            });
        });
}]);