angular.module('WebCacheApp', [ 'frontendServices' ]).controller(
		'MainCtrl',
		['$scope',
		 'UserService',
		 function($scope, UserService, $timeout) {
					$scope.users = {};
					$scope.totalrows = 0;
					$scope.getUsers = function() {
						setAppReady(false);
						UserService.getUsers($scope.vm.name, $scope.vm.phone,
								$scope.vm.company, $scope.vm.iban).then(
								function(data) {
									if (data.valid) {
										$scope.users = data.userList;
										$scope.totalrows = data.count;
										
										setAppReady(true);
									}
								},
			                    function (errorMessage) {
									setAppReady(true);
			                    });

					}
					
					function setAppReady(state) {
						$scope.vm.appReady = state;
		            }
				} 
		]);