<div class="modal fade" id="newUserModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" style="color: #007bff;">Add New User</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<label for="firstName"><span class="glyphicon glyphicon-user"></span> Firstname</label> <input type="text" class="form-control" id="firstName" placeholder="Enter firstName">
					</div>
					<div class="form-group">
						<label for="lastName"><span class="glyphicon glyphicon-eye-open"></span> Lastname</label> <input type="text" class="form-control" id="lastName" placeholder="Enter lastName">
					</div>
					<div class="form-group">
						<label for="email"><span class="glyphicon glyphicon-eye-open"></span> Email</label> <input type="text" class="form-control" id="email" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="phone"><span class="glyphicon glyphicon-eye-open"></span> Phone</label> <input type="text" class="form-control bfh-phone" id="phone" data-format="0 (ddd) ddd-dddd">
					</div>
					<div class="form-group">
						<div class="modal-footer justify-content-between">
							<div id="addcaptcha"></div>
							<ion-icon name="refresh" size="large" onclick="createCaptcha('add');"></ion-icon>
						</div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Captcha" id="addCpatchaTextBox" />
					</div>
					<div class="form-group">
						<label id="newUserErrorLbl" width="100%" height="100%" style="display: none;color:#dc3545"></label>
					</div>
					<button type="button" class="btn btn-default btn-primary btn-block" onclick="insertViaAjax();">
						<span class="glyphicon glyphicon-off"></span> Add
					</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal">
					<span class="glyphicon glyphicon-remove"></span> Cancel
				</button>
			</div>
		</div>
	</div>
</div>
