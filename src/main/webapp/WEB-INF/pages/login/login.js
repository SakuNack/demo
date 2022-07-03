//<![CDATA[
'use strict'
let HOME = (function ($) {
	return {

	}
}(jQuery));

$(document).ready(function () {
	'use strict'
	$('#loginForm').form({
		fields: {
			username: {
				identifier: 'username',
				rules: [
					{
						type: 'empty',
						prompt: 'Please enter a username {name}'
					}
				]
			},
			password: {
				identifier: 'password',
				rules: [
					{
						type: 'empty',
						prompt: 'Please enter a password'
					},
					{
						type: 'minLength[6]',
						prompt: 'Your password must be at least {ruleValue} characters'
					}
				]
			}
		},
		inline: true,
		on: 'blur'

	});

	$('#login').on('click', _.debounce(async event => {
		event.preventDefault();
		if ($('#loginForm').form('validate form')) {
			const loginData = $('#loginForm').form('get values');
			const response = await fetch('/demo/login',
				{
					headers: {
						"Content-Type": "application/json; charset=utf-8"
					},

					method: 'POST',
					cache: 'no-cache',
					body: JSON.stringify(loginData)
				}
			);
			if (response.ok) {
				const loginResult = await response.json();
				if (loginResult) {
					window.location.replace("/demo/pages/home");
				} else {
					const modal = DXCUtils.alertModal('MD0000ERR:login fail', null);
					modal.modal('show');

				}

			} else {
				const modal = DXCUtils.alertModal('MD0001ERR:request error', null);
				modal.modal('show');
			}
		}

	}, 300, true));

});
//]]>