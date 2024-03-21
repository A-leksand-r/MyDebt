const app = angular.module('registration', []).config(function ($httpProvider) {

});

app.controller("registrationController", function ($scope, $http) {

    let usernameIsExist = false;

    $scope.signUp = function(fieldLastName, fieldFirstName, fieldMiddleName, fieldUsername, fieldPassword,
                             fieldRepeatPassword, fieldEmail, fieldPhone){
        $scope.error = "";
        if (fieldLastName && fieldMiddleName && fieldFirstName && fieldUsername && fieldPassword && fieldRepeatPassword && fieldEmail)
            if (fieldPassword !== fieldRepeatPassword) $scope.error = "Пароли не совпадают";
            else
            if (!usernameIsExist) {
                $http.post('/api/v1/registration', {
                    "lastName": fieldLastName,
                    "firstName": fieldFirstName,
                    "middleName": fieldMiddleName,
                    "username": fieldUsername,
                    "password": fieldPassword,
                    "email": fieldEmail,
                    "phone": fieldPhone,
                }).then($scope.successSignUp, $scope.errorSignUp);
            } else $scope.error  = "";
        else {
            $scope.error = "Заполните все обязательные поля.";
        }
    }

    $scope.successSignUp = function () {
        window.location.href = "http://localhost:8080/"
    }

    $scope.errorSignUp = function (response) {
        $scope.error = response.data;
    }

    $scope.checkExistOfUsername = function (fieldUsername) {
        $http.post('/api/v1/existOfUsername/' + fieldUsername
        ).then($scope.check);
    }

    $scope.check = function (response) {
        if (!response.data) {
            $scope.error = "";
            usernameIsExist = false;
        }
        else {
            $scope.error = "Пользователь с таким именем уже существует";
            usernameIsExist = true;
        }
    }

    $scope.redirectToAuthorize = function () {
        window.location.href = "http://localhost:8080/page/login";
    }
});