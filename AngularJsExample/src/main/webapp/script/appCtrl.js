
app.controller('myCtrl',function($scope){

	$scope.Id='';
	$scope.productName='';
	$scope.quantity='';
	$scope.Price='';


	$scope.showMe = false;
	$scope.myFunc = function() {
	$scope.showMe = !$scope.showMe;
	}

});