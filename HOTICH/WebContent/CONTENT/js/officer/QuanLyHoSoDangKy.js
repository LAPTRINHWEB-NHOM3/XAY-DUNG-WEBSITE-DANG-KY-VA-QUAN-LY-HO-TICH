$(document).ready(function() {
	var table = $('#table_id').DataTable({
		"processing" : true,
		"ajax" : {
			"data" : {key : -1},
			"url" : "QuanLyDangKy/getAll",
			"dataSrc":"",
			"type" : "POST",
		},
		"columns" : [ 
		{
			"data": null,
			"className" : 'col-stt',
			"orderable" : false,
		}, 
		{
			"data": "id",
			"className" : 'col-ma',
			"orderable" : false,
			"visible" : false,
		}, 
		{
			"data": "ten",
			"className" : 'col-noidung',
			"orderable" : false,
		}, 
		{
			"data": "ma",
			"className" : 'col-ma',
			"orderable" : false,
		}, 
		{
			"data": "ngayDangKy",
			"className" : 'col-ngay',
			"orderable" : false,
		}, 
		{
			"data": "ngayHetHan",
			"className" : 'col-ngay',
			"orderable" : false,
		}, 
		{
			"data": "loaiGiayTo",
			"className" : 'col-ma',
			"orderable" : false,
			"visible" : false,
		},
		{
			"data": null,
			"className" : 'col-tacvu',
			"orderable" : false,
			"defaultContent": '<div style="text-align: center;"><button class="btn btn-info view"><i class="glyphicon glyphicon-pencil"></i> Kiểm duyệt</button></div>',
		} ],
		scrollCollapse : true,
		lengthMenu : [ [ 10, 25, 50, -1 ], [ 10, 25, 50, "Tất cả" ] ],
		order : false,
		"initComplete": function () {
            var api = this.api();
            api.$('td:not(.col-tacvu)').click( function () {
                api.search( this.innerHTML ).draw();
            } );
        },
	});
	table.on('order.dt search.dt', function() {
		table.column(0, {
			search : 'applied',
			order : 'applied'
		}).nodes().each(function(cell, i) {
			cell.innerHTML = i + 1;
		});
	}).draw();
	$('#table_id tbody').on( 'click', 'td.col-tacvu .view', function () {
		var tr = $(this).closest('tr');
	    console.log( table.row( tr ).data().id );
	    var id = table.row( tr ).data().id;
		var loai = table.row( tr ).data().loaiGiayTo;
		var ma = table.row(tr).data().ma;
		var ten = table.row(tr).data().ten;
	    window.location = "HoSoDangKy/setHSDK?id="+id+"&loai="+loai+"&ma="+ma+"&ten="+ten;
	} );
	setInterval( function () {
	    table.ajax.reload();
	}, 30000 ); // 30 seconds
});
/*
 $.ajax({
 	    	method : "POST",
    		data : {id : table.row( tr ).data().id,
	    			loai : table.row( tr ).data().loaiGiayTo},
	    	url : "HoSoDangKy/setHSDK",
	    	success : function(){
	    		window.location = "HoSoDangKy"
	    	}
	    })
 * */
function showChange(){
	console.log($("#loai-giay").val())
	filterSelection($("#loai-giay").val());
}

function filterSelection(c) {
	var table = $('#table_id').DataTable();
	table.search("").draw();
	if(c == -1){
		table
			.columns(6)
			.search("")
			.draw();
	}
	else{
		table
		.columns(6)
	    .search(c)
	    .draw();
	}
}

function AddClass(element, name) {
	var i, arr1, arr2;
	arr1 = element.className.split(" ");
	arr2 = name.split(" ");
	for (i = 0; i < arr2.length; i++) {
		if (arr1.indexOf(arr2[i]) == -1) {
			element.className += " " + arr2[i];
		}
	}
}

function RemoveClass(element, name) {
	var i, arr1, arr2;
	arr1 = element.className.split(" ");
	arr2 = name.split(" ");
	for (i = 0; i < arr2.length; i++) {
		while (arr1.indexOf(arr2[i]) > -1) {
			arr1.splice(arr1.indexOf(arr2[i]), 1);
		}
	}
	element.className = arr1.join(" ");
}