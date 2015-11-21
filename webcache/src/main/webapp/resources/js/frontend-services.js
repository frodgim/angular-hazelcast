angular.module('frontendServices', [])
    .service('UserService', ['$http', '$q', function($http, $q) {
        return {
        	getUsers: function(name, phone, company, iban) {
                var deferred = $q.defer();
                
                $http.get('/webcache-app/user/getUsersByCriteria',{
                    params: {
                    	name: name,
                    	phone: phone,
                    	company: company,
                    	iban: iban,
                    }
                })
                .then(function (response) {
                    if (response.status == 200) {
                        deferred.resolve(response.data);
                    }
                    else {
                        deferred.reject('Error retrieving list of users');
                    }
                });

                return deferred.promise;
            }
        }
    }]);