'use strict';

App.controller('jdbc-controller', ['$scope', '$http', function ($scope, $http) {
    $scope.user = {id: null, name: '', email: '', role: '', createdDate: ''};

    $scope.getOne = function () {
        $http.get('/user/100000')
            .then(
                function (d) {
                    $scope.user = d.data;
                }
            )
    };

    $scope.save_user = function () {
        var data = {
            name: $scope.name,
            email: $scope.email,
            roles: ['ROLE_USER', 'ROLE_ADMIN']
        };

        $http.post('/user', data)
            .success(function (data, status, headers, config) {
                $scope.message = data;
            })
            .error(function (data, status, header, config) {
                alert( "failure message: " + JSON.stringify({data: data}));
            });

        $scope.name = '';
        $scope.email = '';
    };

    $scope.getOne();
}]);
