const app = angular.module('authorization', []).config(function ($httpProvider) {

});

app.controller("authorizationController", function ($scope, $http) {


    $scope.authorize = function(username, password){
        if (username && password) {
            $http.post('/api/v1/authorize', {"username": username, "password": password} ).
            then($scope.successCallback, $scope.errorCallback);
        } else console.log("Пустой ХУЙ");
    };

    $scope.successCallback = function () {
        window.location.href = "http://localhost:8080/";
    }

    $scope.errorCallback = function () {
        $scope.message = "Неверные учетные данные.";
    }

    $scope.redirectToRegistration = function () {
        window.location.href = "http://localhost:8080/page/registration";
    }
});