<div class="modal fade" id="deleteAllUserModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title">Delete User Collection</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form role="form">
					<div class="form-group">
						<p>Are you sure you want to delete the user collection?</p>
					</div>
					<div class="form-group">
						<div class="modal-footer justify-content-between">
							<div id="deleteAllcaptcha"></div>
							<ion-icon name="refresh" size="large" onclick="createCaptcha('deleteAll');"></ion-icon>
						</div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Captcha" id="deleteAllCpatchaTextBox" />
					</div>
					<div class="form-group">
						<label id="deleteAllUserErrorLbl" width="100%" height="100%" style="display: none;color:#dc3545"></label>
					</div>
				</form>
			</div>
			<div class="modal-footer  justify-content-between">
				<button type="button" class="btn btn-primary" onclick="deleteAllViaAjax();">Delete</button>
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
			</div>
		</div>
	</div>
</div>