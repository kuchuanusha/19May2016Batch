app.controller('myCtrl',function($scope,$http){
		
	var url='http://localhost:8083/FmsParallelProject/ListAllFilms';
	
	$http.get(url)
		.success(function(response){
			$scope.films=response;
		});
	
	});


