<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Hazelcast user cache</title>
	<link rel="stylesheet" href="resources/css/main.css">
	<link rel="stylesheet"
		href="resources/bower_components/bootstrap/dist/css/bootstrap.css">
	<script type="text/javascript"
		src="resources/bower_components/angular/angular.min.js"></script>
	<script type="text/javascript"
		src="resources/bower_components/jquery/dist/jquery.min.js"></script>
	<script type="text/javascript"
		src="resources/bower_components/bootstrap/dist/js/bootstrap.js"></script>
	<script type="text/javascript"
		src="resources/js/frontend-controllers.js"></script>
	<script type="text/javascript" src="resources/js/frontend-services.js"></script>
</head>
<body class="mytheme" ng-app="WebCacheApp">
	<div class="container">

		<h2>Hazelcast Web user cache</h2>

		<div ng-controller="MainCtrl">
			<div class="please-wait-dialog" ng-hide="appReady">
				<img class="please-wait-spinner" src="resources/img/loading.gif">
			</div>
			<div class="row filters">
				<label for="nameFilter">Name:</label> <input class="form-control"
					type="text" name="nameFilter" placeholder="Name..."
					ng-model="vm.name"> <label for="phoneFilter">Phone:</label>

				<input class="form-control" type="text" name="phoneFilter"
					placeholder="Phone..." ng-model="vm.phone"> <label
					for="companyFilter">Company:</label> <input class="form-control"
					type="text" name="companyFilter" placeholder="Company..."
					ng-model="vm.company"> <label for="ibanFilter">IBAN:</label>

				<input class="form-control" type="text" name="ibanFilter"
					placeholder="IBAN..." ng-model="vm.iban">

			</div>
			<div class="row buttonsbar">
				<button class="btn btn-primary" name="filterUserButton"
					value="Filter" ng-click="getUsers()">Filter</button>
			</div>

			<div class="row">
				<span>{{totalItems}} rows in {{timeLoad}} ms.</span>
			</div>
			<div class="row user-list">

				<table class="table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Phone</th>
							<th>Company</th>
							<th>IBAN</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="user in users">
							<td>{{user.name}}</td>
							<td>{{user.phone}}</td>
							<td>{{user.company}}</td>
							<td>{{user.iban}}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>

	</div>


</body>
</html>