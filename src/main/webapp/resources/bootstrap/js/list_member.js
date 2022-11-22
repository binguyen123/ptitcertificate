function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
};

$(document).ready(function(){	
	var table = $('#jTable').DataTable({
	    ajax: 'listData',
	    "order": [],
	    "columns": [
	    	{ "data": "userName" },
            { "data": "firstName" },
            { "data": "lastName" },
            { "data": "password" },
            { "data": "emailAddress" }
        ]
	});
	var dataTemp=new Array();
	$("#addrow").click(function () {
		var data = {"userName":"new user","firstName":"first name","lastName":"last name","password":"password","emailAddress":"email address","dateOfBirth":"441997200000"};
		//alert(JSON.stringify(data));
		dataTemp.push(data);
		var rowNode = table.row.add(data)
	    .draw()
	    .node();
		$(rowNode).css( 'color', 'blue' ).animate({color:'black'});
    });	
	$("#submit").click(function () {
		var dataList = new Array();
		$.each(dataTemp, function (index,value) {
		    dataList.push(value);
		}); 
		var objectData = {};
		objectData.data=dataList;
		//alert(JSON.stringify(objectData));
		$.ajax({
            type: "POST",
            contentType: "application/json",
            url: 'submit',
            data: JSON.stringify(objectData),
            dataType: 'json',
            timeout: 600000,
            success: function (data) {
                alert('update data success');
            },
            error: function (e) {
            	alert('update data failue');
            },
            done : function(e) {
				
			}
		});
	});
	
	$('#jTable').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });
	$('#removeButton').click( function () {
        table.row('.selected').remove().draw( false );
    });
	$('#jTable').on( 'click', 'td', function () {
		console.log( table.cell( this ).data() );
	});
}); 
