<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JDBC</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="../bower/css/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="../static/css/style.css"/>
</head>
<body ng-app="jdbc">

<form ng-controller="jdbc-controller">
    <label for="name"> Name :
        <input type="text" id="name" name="name" ng-model="name"/>
    </label>
    <label for="email"> Email :
        <input type="email" id="email" name="email" ng-model="email"/>
    </label>
    <button ng-click="save_user()">Submit</button>
</form>

<div ng-controller="jdbc-controller" class="container">
    <p>{{user}}</p>
</div>

<script src="../bower/js/angular/angular.min.js"></script>
<script src="../bower/js/angular-route/angular-route.min.js"></script>
<script src="../static/js/app.js"></script>
<script src="../static/js/controller.js"></script>

</body>
</html>
