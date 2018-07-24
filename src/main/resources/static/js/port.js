.angular.module('port', [])
.controller('HomeController', function($scope, $http)
{
	$http.get('https://58zjmoqgyi.execute-api.us-east-2.amazonaws.com/ActionLearning/port').
	then(function(response))
	{
	$scope.port = response.data
	}
})