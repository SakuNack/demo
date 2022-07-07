//<![CDATA[
'use strict'
let GIM = (function ($) {
	return {

	}

}(jQuery));

$(document).ready(async () => {
	'use strict'
	const response = await DXCUtils.callAPI("/master/gim/header/all", "GET", null);
	console.log(response);

	$('#tableSearchRult').DataTable({
		"data": response,
		"columns": [
			{
				"data": "gimType",
				"className": "dt-body-left"

			},
			{
				"data": "gimDesc",
				"className": "dt-body-center"
			},
			{
				"data": "cdLength",
				"className": "dt-body-left"
			},
			{
				"data": "field1Label",
				"className": "dt-body-left"
			},
			{
				"data": "field2Label",
				"className": "dt-body-left"
			},
			{
				"data": "field3Label",
				"className": "dt-body-left"
			},
			{
				"data": "activeFlag",
				"className": "dt-body-left",
				"render": function (data, type, row) {
					return data == "Y" ? "Active" : "Inactive"

				}

			},
			{
				"data": "createdBy",
				"className": "dt-body-center"
			},
			{
				"data": "createdDt",
				"className": "dt-body-center",
				"render": function (data, type, row) {
					return DXCUtils.formatDate(data, 'DD/MM/YYYY HH:mm:ss');

				}
			},
			{
				"data": "modifiedBy",
				"className": "dt-body-center"
			},
			{
				"data": "modifiedDt",
				"className": "dt-body-center",
				"render": function (data, type, row) {
					return DXCUtils.formatDate(data, 'DD/MM/YYYY HH:mm:ss');

				}
			}

		]
	});
});
//]]>