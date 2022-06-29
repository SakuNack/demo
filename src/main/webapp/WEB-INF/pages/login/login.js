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

	$('#login').on('click', _.debounce(function (event) {
		event.preventDefault();
		if ($('#loginForm').form('validate form')) {
			alert('pass validate');
		}

	}, 300, true));

});
//]]>