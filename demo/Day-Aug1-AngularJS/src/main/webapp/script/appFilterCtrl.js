app.controller('fCtrl',function($scope){
	$scope.filtertxt='m';
	$scope.firstName = 'TomJerry';
	$scope.names=[
	              'tom',
	              'ram',
	              'sam',
	              'jerry',
	              'emi'
	               ];
	$scope.employees=[
	                  {empId:1001,empName:'Tom'},
	                  {empId:23,empName:'Jerry'},
	                  {empId:12,empName:'Emi'},
	                  {empId:56,empName:'Jack'},
	                  {empId:789,empName:'Ram'}
	                  
	                  ];
	
	
	
});