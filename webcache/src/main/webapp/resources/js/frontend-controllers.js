angular.module('WebCacheApp', [ 'frontendServices' ]).controller('MainCtrl',
		['$scope',
		 'UserService',
		 function($scope, UserService, $timeout,$log) {
					
			$scope.users = {};
			$scope.totalItems = 0;
			$scope.timeLoad = 0;
			setAppReady(true);
			
			
			$scope.getUsers = function() {
				var t0 = performance.now();
				setAppReady(false);
				UserService.getUsers($scope.vm.name, $scope.vm.phone,
						$scope.vm.company, $scope.vm.iban).then(
						function(data) {
							if (data.valid) {
								$scope.users = data.userList;
								$scope.totalItems = data.count;
								
								setAppReady(true);
								var t1 = performance.now();
								$scope.timeLoad = parseInt(t1 - t0);
							}
						},
	                    function (errorMessage) {
							setAppReady(true);
	                    });

			}
			
			function setAppReady(state) {
				$scope.appReady = state;
            }
		} 
		]);