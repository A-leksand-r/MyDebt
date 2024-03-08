var app = angular.module('authorization', []).config(function ($httpProvider) {

});

app.controller("authorizationController", function ($scope, $http) {


    $scope.authorize = function(username, password){
        if (username && password) {
            var payload = new FormData();
            payload.append("username", username);
            payload.append('password', password);
            $http.post('/api/v1/authorize', payload ).then($scope.successCallback, $scope.errorCallback);
        } else console.log("Пустой ХУЙ");
    };

    $scope.successCallback = function (response) {
        $scope.popa = response.data;
        console.log(response.data);
    }

    $scope.errorCallback = function (error) {
        console.log("Ошибка");
    }
});