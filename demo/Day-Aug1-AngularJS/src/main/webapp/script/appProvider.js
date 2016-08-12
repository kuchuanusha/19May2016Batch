app.config('userProvider',function($provide){
	$provide.provider(function(){
		this.$get=function(){

			var myFunct={};
			
			myFunct.findSquare=function(a){
				return a*a;
			}
			
			myFunct.findSum=function(a,b){
				return a+b;
			}
			return myFunct;
		}
	});
});

app.controller('myCtrl',function($scope,userProvider){
	
	$scope.answer=userProvider.findSquare(5);
});