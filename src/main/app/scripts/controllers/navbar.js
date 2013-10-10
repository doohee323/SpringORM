'use strict';

angular.module('sheepwebApp')
.controller('NavbarCtrl', function ($scope, $location) {
	
	 $scope.myData = [{name: "Moroni", age: 50},
	                     {name: "Tiancum", age: 43},
	                     {name: "Jacob", age: 27},
	                     {name: "Nephi", age: 29},
	                     {name: "Enos", age: 34}];
	    $scope.gridOptions = { data: 'myData' };	
	
    $scope.goTo = function ( baseUrl, center ) {
    	var path = baseUrl;
    	if(baseUrl == '/') {
    	} else if(center) {
    		path += center.id;
    	} else if($scope.uip_centers[0]) {
    		path += $scope.uip_centers[0].id;
    	}
	  	$location.path( path );
	}	
});

