app.factory('mathFunctions',function(){
	var fac={};
	fac.findSquare=function(a){
	
		return a*a;
	}
	return fac;
});
app.factory('textFunctions',function(){
	var fac={};
	fac.findConcate=function(a,b){
	
		return a+b;
	}
	return fac;
});
app.controller('myCtrl',function($scope,mathFunctions,textFunctions){
$scope.myNum=mathFunctions.findSquare(5);
$scope.result=mathFunctions.findSquare(5);
$scope.firstName="anusha";
$scope.lastName="kuchu";
$scope.concate = function() {
alert(textFunctions.findConcate($scope.firstName,$scope.lastName));
}
});