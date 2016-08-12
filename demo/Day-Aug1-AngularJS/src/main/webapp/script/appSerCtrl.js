app.service('userService',function(){
	
	this.greetings=function(){
		//alert('hello');
		return 'Hello! Welcome To Angular!';
	};
	
	this.fullName=function(firstname,lastName){
		
		return firstname+' ' + lastName;
	};
});

app.controller('demoCtrl',function($scope,userService){
	$scope.msg=userService.greetings();
	$scope.myName=userService.fullName('Tom','Jerry');
});