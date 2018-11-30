<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>UMP</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://unpkg.com/ionicons@4.4.8/dist/css/ionicons.min.css" rel="stylesheet">
<script src="https://unpkg.com/ionicons@4.4.8/dist/ionicons.js"></script>

<script src="https://code.jquery.com/jquery-3.1.1.min.js" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js">
	
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/3.1.60/inputmask/jquery.inputmask.js"></script>
<script src="resources/js/us_ajax.js"></script>

</head>

<body>
	<%@include file="navbar.jsp"%>
	<%@include file="new_user.jsp"%>
	<%@include file="update_user.jsp"%>
	<%@include file="delete_user.jsp"%>
	<%@include file="delete_all_user.jsp"%>
	<div class="table-responsive">
		<table id="tableListUserCollection" class="table table-bordered table-striped">
			<!-- List user -->
			<thead>
				<tr>
					<th width="15%">First Name</th>
					<th width="15%">Last Name</th>
					<th width="10%">Email</th>
					<th width="10%">Phone Number</th>
					<th width="10%">Edit</th>
					<th width="10%">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listUser }" var="i">
					<!-- Add users list via get method from page control method(getMainPage()) -->
					<tr>
						<td id="${i.id}tablefirstName">${i.firstName}</td>
						<td id="${i.id}tablelastName">${i.lastName}</td>
						<td id="${i.id}tableemail">${i.email}</td>
						<td id="${i.id}tablephone">${i.phone}</td>
						<td><button type="button" data-id="${i.id}" class="btn btn-default btn-success editClass" data-toggle="modal" data-target="#updateUserModal">Edit</button></td>
						<td><button type="button" data-id="${i.id}" class="btn btn-default btn-danger deleteClass" data-toggle="modal" data-target="#deleteUserModal">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<div id="wait" style="display: none; width: 100%; height: 100%; top: 100px; left: 0px; position: fixed; z-index: 10000; text-align: center;">
		<img src="resources/css/images/Pacman-1s-200px.gif" width="200px" height="200px" alt="Loading..." style="position: fixed; top: 45%; left: 45%;" />
	</div>
	</form>
</body>
</html>