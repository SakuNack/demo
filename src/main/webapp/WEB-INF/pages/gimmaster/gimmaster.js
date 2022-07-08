//<![CDATA[
'use strict'
let GIM = (function ($) {
	return {
		DATA_KEY: {
			GIM_HEADER_DATA_LIST: "gimheaderdatalist",
		},
		localData: localDataStorage('gimmaster'),
		dataStoreMntChanged: async e => {
			if (e.detail.key == GIM.DATA_KEY.GIM_HEADER_DATA_LIST) {
				console.log(GIM.localData.get(e.detail.key));
				GIM.rederGimHeaderDataTable();
			}
		},
		rederGimHeaderDataTable: async () => {
			const response = GIM.localData.get(GIM.DATA_KEY.GIM_HEADER_DATA_LIST) == null ? [] : GIM.localData.get(GIM.DATA_KEY.GIM_HEADER_DATA_LIST);
			if ($.fn.DataTable.isDataTable('#tableSearchResult')) {

				let table = $("#tableSearchResult").DataTable();

				table.clear();

				table.search('');

				table.rows.add(response).draw();

			} else {
				$('#tableSearchResult').DataTable({
					"data": response,
					"columns": [
						{
							"data": "gimType",
							"className": "dt-body-left"

						},
						{
							"data": "gimDesc",
							"className": "dt-body-left"
						},
						{
							"data": "cdLength",
							"className": "dt-body-right"
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
								return data == "Y" ? "Active" : "In-Active"
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
			}

		},
	}

}(jQuery));

$(document).ready(async () => {
	'use strict'
	$.fn.dataTable.moment("DD/MM/YYYY HH:mm:ss");

	document.addEventListener("localDataStorage", GIM.dataStoreMntChanged, false);

	GIM.localData.remove(GIM.DATA_KEY.GIM_HEADER_DATA_LIST);

	const response = await DXCUtils.callAPI("/master/gim/header/all", "GET", null);
	console.log(response);

	GIM.localData.set(GIM.DATA_KEY.GIM_HEADER_DATA_LIST, response)


});
//]]>