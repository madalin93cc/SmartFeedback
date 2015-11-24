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
    .controller('MainCtrl', ['$scope', function ($scope) {
        this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];

        var select = document.getElementById("selectNota");
        var options = ["1", "2", "3", "4", "5", "6", "7", "8", "9", "10"];
        for(var i = 0; i < options.length; i++) {
            var opt = options[i];
            var el = document.createElement("option");
            el.textContent = opt;
            el.value = opt;
            if(i  == 4) {
                el.selected = true;
            }
            select.appendChild(el);
            if(i == 9) {
                select.removeChild(select.childNodes[1]);
            }
        }

    }]);


