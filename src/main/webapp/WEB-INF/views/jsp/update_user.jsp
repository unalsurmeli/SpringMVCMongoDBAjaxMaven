<div class="modal fade" id="updateUserModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" style="color: #007bff;">Edit User</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<input type="hidden" name="updateshiddenValue" id="updateHiddenValue" value="" />
				<form role="form">
					<div class="form-group">
						<label for="updatefirstName"><span class="glyphicon glyphicon-user"></span> Firstname</label> <input type="text" class="form-control" id="updatefirstName" placeholder="Enter firstName">
					</div>
					<div class="form-group">
						<label for="updatelastName"><span class="glyphicon glyphicon-eye-open"></span> Lastname</label> <input type="text" class="form-control" id="updatelastName" placeholder="Enter lastName">
					</div>
					<div class="form-group">
						<label for="updateemail"><span class="glyphicon glyphicon-eye-open"></span> Email</label> <input type="text" class="form-control" id="updateemail" placeholder="Enter email">
					</div>
					<div class="form-group">
						<label for="updatephone"><span class="glyphicon glyphicon-eye-open"></span> Phone</label> <input type="text" class="form-control bfh-phone" id="updatephone" data-format="0 (ddd) ddd-dddd">
					</div>
					<div class="form-group">
						<div class="modal-footer justify-content-between">
							<div id="updatecaptcha"></div>
							<ion-icon name="refresh" size="large" onclick="createCaptcha('update');"></ion-icon>
						</div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Captcha" id="updateCpatchaTextBox" />
					</div>
					<div class="form-group">
						<label id="updateUserErrorLbl" width="100%" height="100%" style="display: none;color:#dc3545"></label>
					</div>
					<button type="button" class="btn btn-default btn-primary btn-block" onclick="updateViaAjax();">
						<span class="glyphicon glyphicon-off"></span> Update
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
