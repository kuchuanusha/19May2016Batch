app.factory('printGreetings',function(){
	return 'Good Morning! Hello All!';
	
});

app.factory('mathFunc',function(){
	var myFunct={};
	
	myFunct.findSquare=function(a){
		return a*a;
	}
	
	myFunct.findSum=function(a,b){
		return a+b;
	}
	
	
	return myFunct;
	
});


app.controller('myCtrl',function($scope,count,userName,printGreetings){
	console.log('Count Vaule:' + count);
	console.log('UserName:' + userName);
	$scope.greetMsg=printGreetings;
	$scope.uname=userName;
});

app.controller('mathCtrl',function($scope,mathFunc,count){
	
	$scope.myNum=10;

	$scope.calculate=function(){
		alert(mathFunc.findSquare($scope.myNum));
		//return mathFunc.findSquare($scope.myNum);
	};
	
});


