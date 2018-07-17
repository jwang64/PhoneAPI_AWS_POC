<!doctype html>
<html ng-app>
  <head>
    <title>Angularjs Spring MVC sample application</title>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    <script>
      function Hello($scope, $http) {
        $scope.getUserDetails = function()
        {
           $http.get('http://localhost:8080/Spring-Angularjs-Tutorial/userdetails').
           success(function(data) {
           $scope.user = data;
        });
      }
    }
    </script>
   </head>
   <body>
     <div ng-controller="Hello">
       <h2>Angularjs Spring MVC sample application!!</h2>
       <button ng-click="getUserDetails()">Get User Details</button>
       <p>Name : {{user.name}}</p>
       <p>Department : {{user.department}}</p>
     </div>
   </body>
</html>
