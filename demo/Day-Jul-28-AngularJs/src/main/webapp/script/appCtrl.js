app.controller('myCtrl',function($scope){
		$scope.msg='HelloWorld! Welcome To Angular FrameWork.';
		
		$scope.myFunc=function(){
			//$scope.greetings='Hello!';
			alert('Hello!');
		};
	});


app.controller('helloCtrl',function($scope){
	$scope.greetings='Hello! Good Morning!';
	$scope.firstName='Tom';
	$scope.lastName='Jerry';
	$scope.age=21;
	$scope.salary=23000;
	
});